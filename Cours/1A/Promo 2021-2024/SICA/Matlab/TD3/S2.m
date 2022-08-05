% TD Analyse Spectrale

% Analyse temporelle
% Tout dépend de la consigne

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
% signal sinusoidale = A*sin(2*pi*f0*t) (parfois sans le A car pas donné)

% Affichage
% courbe
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

% Exemple 2
nfft=2^nextpow2(4*N); % nombre d'échantillon (cf zero padding)
Yb=abs(fft(yb, nfft));  % spectre (déjà en abs)
Yb=Yb(1:nfft/2); 
F=[0:nfft/2-1]/nfft*Fe;
figure(2); plot(F, Yb);
xlabel('F [Hz]'); ylabel('|TF(yb)|'); title('Spectre du signal original');

% Amélioration de la TF (zero padding)
% Ajouter des échantillons améliore la visibilité de la TF

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

% Exemple 2
nfft=2^nextpow2(4*N); % zero padding
Yb=abs(fft(yb, nfft)); Yb=Yb(1:nfft/2);
F=[0:nfft/2-1]/nfft*Fe;
figure(2); plot(F, Yb);
xlabel('F [Hz]'); ylabel('|TF(yb)|'); title('Spectre du signal original');

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
