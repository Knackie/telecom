# -*- coding: utf-8 -*-

from numpy import ones, zeros, log, exp, copy, abs, ceil, cos,pi,fft,median, sqrt
import matplotlib.pyplot as plt
import librosa
import json

##constantes
fmax = 3000 #fréquence max 
fmin = 150 
fe = 44100
fc = 30000
alpha = 2
ecart_amplitude_pitch = 0.6


def computeSpectrum(fileName, plot=False):
    try:
        data, sampling_rate = librosa.load('sounds/'+fileName)
    except:
        return ones(0)
    return computeTab(data,sampling_rate,plot=plot,titre=fileName)

def computeTab(data,sampling_rate,plot=False,titre="sansTitre"):

    data = data[0:2048] 
    N = len(data) # nv d'échantillons
    ##2.3 fenetrage

    w = ones(N) # vecteur de taille n
    #origine des temps au debut de la zone, ce qui donne la formule de W
    for n in range(0, N):
        w[n] = (1 + cos(pi * (n - N / 2) / N)) / 2

    ##2.4 Calcul du spectre

    x = w * data #signal fenetré
    X = fft.fft(x) # transformé pour avoir amplitude en fctn de la fréquence
    #on prends le module de chaque échantillons.
    X = abs(X)

    ##2.5 Extraction de partie utile du spectre

    Kmax = round(N * fmax / fe) # represente le nombre d'échantillons.
    X = X[0:Kmax]
    Kmin = round(N * fmin / fe) #-fréquence min
    for k in range(0, Kmin):
        X[k] = 0 # prends pas en compte car inférieur a kmin

    ##2.6
    P = zeros(Kmax) #accentuation
    kc = Kmax * fc / fe # fréquence coupure
    for k in range(0, Kmax):
        ##P[k]=sqrt((k/kc)*2*alpha+1)
        P[k] = k / kc + 1 #P(k)

    Y = zeros(Kmax)
    for k in range(0, Kmax):
        Y[k] = P[k] * X[k]  #application accentuation

    ##2.7 logarithme biaisé simplifié

    my = 0
    for k in range(0, Kmax):
        my = my + Y[k]
    my = my / Kmax
    B = 1 / 100 * my
    for k in range(0, Kmax):
        Y[k] = log(Y[k] + B) 

    ##2.8 lissage du spectre
    imax = max(Y) #pitch
    Q = 0 # q est le pitch a trouver, equivaut a la fréquence du premier VRAI harmonique
    prec=-10000 #
    while Y[Q]<imax*ecart_amplitude_pitch and prec <= Y[Q]: #valeur = imax - ecart amplitude
        prec=Y[Q]
        Q += 1   ## amelioration : trouver la frequence du pitch

    ww = zeros(Q)
    Sw = 0
    for q in range(0, Q):
        ww[q] = (1 + cos(pi * (q - Q / 2) / Q)) / 2
        Sw += ww[q]

    ww = ww / Sw

    tmp = copy(Y)
    for k in range(0, Kmax):
        sum = 0
        for q in range(0, Q):
            if 0 <= k - q + 10 < Kmax:
                sum += ww[q] * tmp[k - q + 10]
        Y[k] = sum

    ##2.9 Exponentiation biasié

    H = zeros(Kmax)

    for k in range(0, Kmax):
        H[k] = exp(Y[k]) - B #application formule

    ##2.10 Comparaison
    mh = 0
    for k in range(0, Kmax):
        mh+=H[k]
    mh=mh/Kmax

    oh = 0
    for k in range(0, Kmax):
        oh+=(H[k]-mh)*(H[k]-mh)
    oh=sqrt(oh/Kmax)

    for k in range(0, Kmax):
        H[k]=(H[k]-mh)/oh

    if plot:
        ## affichage
        plt.figure(figsize=(12, 8))
        plt.plot(H)

        plt.xlabel('x label')
        plt.ylabel('y label')

        plt.title(titre)
        plt.show()

    return H,Q



#Y = computeSpectrum("a_pbouillon_2.wav", plot=False)







