%%Exo 1
%
%G(s) = K/1+sT
%k=10 et t=2
%Tracer la réponse indicielle de G(s)
% ----------------------

T = 2;
k = 10;
% fonction de transfere : 
G = tf([0 k],[T 1]);
% Affichage
subplot(2,2,1);
% réponse impulsionnelle
impulse(G);
% Affichage
subplot(2,2,2);
%réponse indicielle
stepplot(G);

% OU
s = tf('s');
F1 = (k) / (1 +s * T);
F1.num{1}
F1.den(1)
%get(F1);
%methods(F1)

% Affichage
subplot(2,2,3);
% réponse impulsionnelle
impulse(F1)
% Affichage
subplot(2,2,4);
%réponse indicielle
stepplot(F1);


