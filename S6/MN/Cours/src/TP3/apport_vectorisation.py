"""test pour voir l'apport de la vectorisation pour la fonction affectation"""

from hmeans import *
import numpy as np
from time import time

np.random.seed(7)
C = np.array([[-1,0],
              [1,0],
              [0,1],
              [0,-1]])
sigma_K = [3, 4, 5, 4.5]
n_K = [15000, 11000, 7000, 8000]

X = fabrique_donnees(C, sigma_K, n_K)

t0 = time()
classe, I = affectation(X, C)
tscal = time() - t0
t0 = time()
G = barycentrage(X, classe, 4)
tbscal = time() - t0

t0 = time()
classe_ref, I_ref = affectationv(X, C)
tvec = time() - t0
t0 = time()
G_ref = barycentragev(X, classe_ref, 4)
tbvec = time() - t0

if np.all(classe == classe_ref) and np.allclose(I, I_ref) and np.allclose(G, G_ref):
    print(" justesse : OK")
else:
    print(" justesse : pas OK")
    

print(f' temps scalaire affectation = {tscal}')
print(f' temps vectoriel affectation = {tvec}')
print(f' scal/vec affectation= {tscal/tvec}')

print(f' temps scalaire barycentrage = {tbscal}')
print(f' temps vectoriel barycentrage = {tbvec}')
print(f' scal/vec barycentrage= {tbscal/tbvec}')


