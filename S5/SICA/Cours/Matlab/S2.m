% MATLAB
% Révisions S1

% Tips sympa
snr(x,y) % rsb signal/bruit

% Exercice 1
Fs = 100; % fréquence d'échantillonnage
t = (1:100)/Fs; % temps
f = [ 2; 15; 25]; % fréquence sinusoïdes
A = [.5 .9 .8]; % amplitude sinusoïdes
x = A*sin(2*pi*f*t); % signal à 3 sinusoïdes
b = randn(size(x)); % bruit blanc gaussien
b = b/std(b);
x = x+b; % signal bruité

% Exercice 2
N = 16; 
Te = .00390625;
k = 0:N-1;
x = sin(2*pi*32*k*Te);
% Pourquoi 32 ?
% 1/Te = 256 Hz
% 1/Nte = 16
% fréquence = 32
X = fft(x); 
magX=abs(X);
stem(k,magX),grid % mal gradué

f = (0 : N-1)/(N*Te); 
stem(f,magX),grid % bien gradué (zero padding)

stem(k,fftshift(magX))

% Exercice 3
% C'est quoi le zero-padding et quelle est son utilité ?
% = Compléter une séquence initiale avec des valeurs nulles
% => Améliorer le tracé du spectre en augmentant artificiellement le nombre de
% points sur lequel est calculée la TF

% Quelle est l'influence des fenêtres ?
% = Limitation en durée d'un signal (d'où le nom)
% => Cette limitation ce traduit par une convolution par un sinus cardinal =>
% lobe principales et lobes secondaires
% Différentes fenêtres = différents compromis entre largeur des lobes

% Exercice 4
x = [1 2 3];
y = [5 4 0];
conv(x,y) % convolution discrète

X = fft(x);
Y = fft(y);
P = X.*Y;
z = real(ifft(P)); % même calcul dans le domaine fréquentiel et revenir dans domaine temporel

X = fft(x,5);
Y = fft(x,5);
P = X.*Y;
z = real(ifft(P)); % on rajoute des valeurs nulles pour éviter problème de convolution circulaire

% Exercice 6
N=1024; 
fs=500; 
Ts=1/fs; 
T=0.05;
x=sqrt(3)*sin(2*pi*(0:N-1)/(T*fs)+pi/4);
x=x(:); 
win=bartlett(N); 
xw=win(:).*x;
Px=abs(fft(x)); 
Pxw=abs(fft(xw));
w=2*pi*(0:N/2-1)*fs/N;
plot(w,[Px(1:N/2) Pxw(1:N/2)]);
% Ce programme génère un signal sinusoïdal et en effectue l'analyse spectrale avec fenêtre
% rectangulaire puis avec fenêtrage triangulaire (fenêtre de Bartlett). Les deux résultats sont
% ensuite représentés sur une même figure.

% Exercice 10
fe=500; %fréquence d'échantillonnage
Te=1/fe; %pas d'échantillonnage
f0=50; %fréquence de la sinusoïde
A=4; %amplitude de la sinusoïde
t=0:Te:1; %axe du temps
N=length(t); %nombre d'échantillons du vecteur temps (501)
s=A*sin(2*pi*f0*t); %signal sinusoïdal
[NL,NC]=size(s); %nombre de lignes et colonnes du vecteur s (NL=1 et NC=N)
%il s'agit donc d'un vecteur ligne
E=sum(s.^2); %énergie du signal (~=4000)
P=E/N; %puissance moyenne du signal sur N échantillons (~=7,984)
%puissance théorique = A^2/2=8, à comparer à P
b=randn(size(t)); %bruit blanc gaussien
b=(b-mean(b))/std(b); %bruit centré réduit
b=b*sqrt(10*P); %ajustement de la puissance
Eb=sum(b.^2); %énergie du bruit (~=39920)
Pb=Eb/N; %puissance moyenne du bruit sur N échantillons (~=79,68)
rsb=10*log10(P/Pb); %calcul du RSB expérimental (~=-9,99)
%Le RSB théorique est donné par 10*log10(1/10)=-10dB
sb=s+b; %sinus bruité
%la puissance moyenne de ce signal est approximativement égale à
%la somme des deux puissances moyennes
%représentations graphiques
figure(1)
plot(t,sb),grid, title('sinus bruité'), xlabel('temps'),
ylabel('amplitude');
figure(2)
plot(t,s,t,sb),grid, title('sinus avec et sans bruit'), xlabel('temps'),
ylabel('amplitude');
legend('sinus','sinus bruité')
M=zeros(N,3); %création de la matrice
M=[s' b' sb'];
figure(3)
plot(t,M),grid, title('les 3 signaux'), xlabel('temps'),
ylabel('amplitude');
legend('sinus','bruit','sinus bruité')
%calcul de l'intercorrélation
[ac,lags]=xcorr(s,sb,20,'unbiased');
figure(4),plot(lags,ac),grid
%l’intérêt est de détecter la présence de la sinusoïde dans le signal bruité

% Exercices S2

% Analyse temporelle
% Exemple 1
load('seqclavier.mat'); % signal yb
Fe=32768; % fréquence d'échantillonage
N=length(yb); % nombre d'échantillon
t=[0:N-1]/Fe; % vecteur temps

% Exemple 2
f0 = 25; % fréquence du signal
fe = 1000; % fréquence d'échantillonage
N = 320; % nombre d'échantillon
Te = 1/fe; % période échantillonage
tfin = N/fe - 1/fe;
t = 0:Te:tfin; % vecteur temps
x = A*sin(2*pi*f0*t); % signal

% Exemple 3
f0=20; % frequence du sinus
N=64; % nb points temporels
fe=128; % frequence d'échantillonnage du signal
Te=1/fe; % periode d'échantillonage
k=0:N-1; % indice temporel
t=k*Te; % temps
x=sin(2*pi*f0*t); % sin tronquée = sin x rect (N points)

% Résumé
% f0 = fréquence du signal
% fe = ... fréquence d'échantillonage (souvent dans la consigne)
% Te = 1/fe;
% N = ... nombre d'échantillon (donné ou length(sig))
% t = [0:N-1]/fe = (0:N-1)*Te
% signal sinusoidale = A*sin(2*pi*f0*t)

% Affichage
figure(1); 
plot(t, yb); % courbe
stem(t,yb); % bâton
xlabel('t [sec]'); ylabel('yb(t)');
title('Signal');

% Rappel : bruit blanc gaussien
b = randn(size(y));
b = b-mean(b);
b = b/std(b);
% b = sqrt(0.2)*b; pour forcer la variance à 2 (si demandé)
% varb = var(b); vérification variance

% Analyse spectrale
% spectre = TF = fft()

% Exemple 1
% Spectre d'amplitude
Nf=N; % on prend le même nombre d'échantillons
n=0:Nf-1; % indice frequentiel
f=n*fe/Nf; % axe des fréquences
X=fft(signal,Nf)/N; % le spectre

% Affichage 
figure
stem(f,abs(X)) % ou plot
title(['spectre d''amplitude de X - f0=',num2str(f0),', fe=',num2str(fe),', Nf=', num2str(Nf),', N=',num2str(N)])
xlabel('frequence f (en Hz)' )
ylabel('amplitude')

% Spectre d'amplitude théorique
Xsh=fftshift(X);
nsh=-Nf/2:Nf/2-1; % indice fréquentiel (Nf doit être un nombre pair (consigne))
fsh=nsh*fe/Nf; % axe des fréquences

% Affichage
figure
stem(fsh,abs(Xsh))
title('spectre d''amplitude entre -fe/2 et fe/2')
% Rogné : entre 0 et fe/2(-1 échan)
figure
stem(fsh(Nf/2+1:end),abs(Xsh(Nf/2+1:end)))
stem(f(1:Nf/2),abs(X(1:Nf/2))) % autre solution à partir de X sans fftshift
title('spectre d''amplitude entre 0 et fe/2')

% Amélioration de la TF (zero padding)
% = Ajouter des échantillons améliore la visibilité de la TF

% Exemple 1.1
Nz=64;
x1=[x(:)' zeros(1,Nz)];
% nouveaux axes fréquentiels
Nf=length(x1);
k=0:Nf-1;
f=k*fe/Nf;
X1=fft(x1);
magX1=abs(X1);

% Exemple 1.2
Nf=2*N;
k=0:Nf-1;
f=k*fe/Nf;
X=fft(x,Nf);
magX=abs(X);

% Affichage
figure
stem(f(1:Nf/2),magX1(1:Nf/2)) % axe fréquentiel positif
xlabel('axe frequentiel f')
title('spectre d''amplitude en fonction de f - zero padding 1')
grid on

% Fenêtrage
% Appliquer des fenêtre définies
N=32;
k=0:N-1;
Te=1;
fe=1/Te;
t=k*Te;

f1=bartlett(N);
f2=blackman(N);
f3=kaiser(N,5);
f4=chebwin(N,20);
frect=rectwin(N);
 
figure
plot(t,[f1,f2,f3,f4,frect])
grid on
xlabel('t (temps)')
ylabel('amplitude')
title('représentation temporelle des fenêtres')
legend('bartlett','blackman','kaiser','chebychev','rectangulaire')

% Fenêtrage et TF
Nf=1024;
n=(-Nf/2:Nf/2-1);
f=n*fe/Nf;
 
FRect=fftshift(fft(frect,Nf));
F1=fftshift(fft(f1,Nf));
F2=fftshift(fft(f2,Nf));
F3=fftshift(fft(f3,Nf));
F4=fftshift(fft(f4,Nf));
 
figure
plot(f,abs([FRect F1 F2 F3 F4])) % ou stem puisque le spectre est discret
% plot(f,10*log10(abs([FRect F1 F2 F3 F4]))) => module en dB
% semilogy(f,abs([FRect F1 F2 F3 F4])) => module en dB
grid on
xlabel('f (frequence)')
ylabel('module |F(f)|')
title('spectre d''amplitude')
legend('rectangulaire','bartlett','blackman','kaiser','chebychev')

% Filtrage
fc=1600;
[B, A]=butter(4, 2*fc/fe);
y = filtfilt(B, A, yb);
figure(3); plot(t, y); xlabel('t [sec]'); ylabel('y(t)'); title('Signal filtré');

% Segmentation
y1 = y(1:10000); Y1=abs(fft(y1, nfft)); Y1=Y1(1:nfft/2);
y2 = y(15001:25000); Y2=abs(fft(y2, nfft)); Y2=Y2(1:nfft/2);
y3 = y(30001:35000); Y3=abs(fft(y3, nfft)); Y3=Y3(1:nfft/2);

figure;
subplot(3,1,1); plot(f, Y1); ylabel('Segment 1');
subplot(3,1,2); plot(f, Y2); ylabel('Segment 2');
subplot(3,1,3); plot(f, Y3); ylabel('Segment 3');