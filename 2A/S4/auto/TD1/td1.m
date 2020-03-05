% TD1 Automatique S4

% Fonction de transfert du système de 1er ordre
% Détermination graphique du gain K et de T
K = 3;
T = 2;
tt = T;

load 'C:\Users\Utilisateur\telecom\2A\S4\auto\TD1\EssaiIndicielTemp.mat';

t = 0:Te:65*Te;
Y_k = 1 - exp(-tt/T);
Y = K * Y_k;
s = tf('s') ;
G = K / (1 + s * T) ;
Chargement du fichier du prof :
load('EssaiIndicielTemp.mat');

s = tf('s');
X = 0.5 * (1 / s);
t = (-5 * Te):Te:(60 * Te);
T = 2;

K1 = 3;
H1 = K1 / (1 + s * T);
a = impulse(H1 * X, t) + 1;
y1 = [ones([5 1]); a];
figure();
subplot(2, 1, 1);
stairs(t, temp, "-m");
subplot(2, 1, 2);
plot(t, y1, "-b", t, y, "-r");



Donc  et 
K2 = 100;
H2 = (K2 / (1 + K2)) / (1 + s * (T / (1 + K2)));
y2 = impulse(H2 * X, t);
% figure();
% plot(t, y2, "-b");

Chargement du fichier du prof :
load('EssaiIndicielTemp.mat');

s = tf('s');
X = 0.5 * (1 / s);
t = (-5 * Te):Te:(60 * Te);
T = 2;

K1 = 3;
H1 = K1 / (1 + s * T);
a = impulse(H1 * X, t) + 1;
y1 = [ones([5 1]); a];
figure();
subplot(2, 1, 1);
stairs(t, temp, "-m");
subplot(2, 1, 2);
plot(t, y1, "-b", t, y, "-r");



Donc  et 
K2 = 100;
H2 = (K2 / (1 + K2)) / (1 + s * (T / (1 + K2)));
y2 = impulse(H2 * X, t);
% figure();
% plot(t, y2, "-b");


[Ys, Ts] = step(G) ;
Ys = Ys*temp
% Affichage
h = 1;
l = 3;

reponse_indicielle_g = subplot(h, l, 1);
entree_sys = subplot(h, l, 2);
sortie_sys = subplot(h, l, 3);

plot(reponse_indicielle_g ,Ts ,Ys ,'g');
title(reponse_indicielle_g, 'Réponse indicielle de G(s)');

plot(entree_sys, t, temp, 'g');
title(entree_sys, 'Entrée système');

plot(sortie_sys, t, y, Ts ,Ys ,'g');
title(sortie_sys, 'Sortie système');