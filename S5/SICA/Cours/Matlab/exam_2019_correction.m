close all;
clear all;

% Création et analyse d’un signal carré retardé

% Question 1 : générer le signal x(t)
f0=1; % fréquence signal
fe=500; % fréquence d'échantillonage
Te=1/fe; % période échantillonage
t=0:Te:2; % de 0 à 2 secondes avec un pas de Te
x=0.5+square(2*pi*f0*t)/2; % le signal

% Question 2 : la taille de x(t)
sx=length(x); % donne juste ligne
sxbis=size(x); % donne colonne et ligne
% Réponse : La taille de x(t) vaut 1001 ou [1,1001].

% Question 3 : la puissance moyenne px de x(t)
px=sum(x.^2)/length(x);

% Question 4 : créer le signal retardé y(t)
y=0.5+square(2*pi*f0*(t-0.25))/2;

% Question 5 : tracer les signaux sur la même figure
figure
plot(t,x,t,y)
legend('signal initial x(t)','signal retardé y(t)')
title('Les signaux')
xlabel('temps (secondes)')
ylabel('amplitude (Hz)')

% Remarque MT : il est possible d'ajouter une grille et changer les limites de l'axe y 
% (même si ce n'était pas demandé pour mieux voir les signaux)
grid on
ylim([-1 2])

% Signal bruité
% Question 6 : créer le bruit blanc gaussien b
b = randn(size(y));
b = b-mean(b);
b = b/std(b);
b=sqrt(0.2)*b; % pour forcer la variance à 2
varb=var(b); % vérification
% ? : Comment déterminer la puissance et variance ?

% Question 7 : le rapport signal sur bruit entre y et b
py=sum(y.^2)/length(y); % puissance signal
pb=0.2; % puissance bruit (d'après les questions précédentes)
rsb=10*log10(py/pb); % rapport signal sur bruit
% Réponse : Le rapport signal sur bruit (rsb) vaut 3.98 dB.

% Question 8 : créer le signal retardé bruité yb et le tracer
yb=y+b; % signal bruité
figure % représentation
plot(t,x,t,y,t,yb)
legend('signal initial x(t)','signal retardé y(t)','signal retardé bruité y(t)')
title('Les signaux')
xlabel('temps (secondes)')
ylabel('amplitude (Hz)')

% Remarque MT : idem question précédente
grid on
ylim([-1 2])

% Question 9 : la fonction d'autocorrélation du signal yb

% Façon naïve et incorrecte de le faire :
%ry=xcorr(yb,x); %calcul
%figure % représentation
%plot(rybx)
% L'axe des absisses (décalage tau) n'est pas bon.
% Remarque MT : je vous conseille de récuperer le vecteur des décalages lorsque vous
% faites la correlation (plus simple que de le recréer)

[ry,lags]=xcorr(yb,'unbiased');
tau=lags*Te; % et on multiplie par Te pour avoir les décalages en secondes

figure
plot(tau, ry)
grid
title('Autocorrelation de yb')
xlabel('Décalage (en s)')
ylabel('ryb')

% Question 10 : commentaires de la figure
% Remarque MT : ryb(0)=0.7=Ps+Pb (puissance du signal + puissance du bruit)

% Question 11 : la fonction d'intercorrélation entre yb et x
[zz,lags]=xcorr(yb,x);

figure
plot(tau, zz)
grid
title('Intercorrelation entre yb et x')
xlabel('Décalage (en s)')
ylabel('rybx')

% Question 12 : déterminer décalage
% Remarque MT : il faut consulter l'aide de la fonction max pour pouvoir retrouver
% l'indice pour lequel la fonction est maximale
[v,nmax]=max(zz);
tmax=tau(nmax)

% Question 13 : commentaires
% Remarque MT : ce décalage correspond au retard du signal y