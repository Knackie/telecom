%%
% ---------------------------------------------
% Partie n°1: 
%
% G(s) = K / (1 + sT)
% K = 10
% T = 2
%
% 1/ Tracer la réponse indicielle de G(s)
% 2/ Tracer la réponse impulsionnelle de G(s)
% ---------------------------------------------

% initialise les constantes
K = 10;
T = 2;

% initialise l'affichage
height = 3;
column = 2;
figure('Name', 'Automatique - TP n°1', 'NumberTitle', 'off')

% declare `s` en tant que variable de Laplace
s = tf('s');

% création de la fonction de transfert G
G = K / (1 + s * T);

% récupère la réponse indicielle
[Ys, Ts] = step(G);

% récupère la réponse impulsionnelle
[Yt, Tt] = impulse(G);

% affiche la réponse indicielle
rep_indicielle_g = subplot(height, column, 1);

stepplot(rep_indicielle_g, G);
title(rep_indicielle_g, 'Réponse indicielle G(s)');

% affiche la réponse impulsionnelle
rep_impulsionnelle_g = subplot(height, column, 2);

impulseplot(rep_impulsionnelle_g, G);
title(rep_impulsionnelle_g, 'Réponse impulsionnelle G(t)');

%%
% ---------------------------------------------
% Partie n°2: 
%
% G2(s) = K / ((1 + sT)(1 + s(T / 10)))
% K = 10
% T = 2
%
% 1/ Tracer la réponse indicielle de G2(s)
% 2/ Tracer la réponse impulsionnelle de G2(s)
% 3/ Comparer les réponses
% ---------------------------------------------

% création de la fonction de transfert G2
T2 = T / 10;
G2 = K / ((1+ s * T) * (1 + s * T2));

% récupère la réponse indicielle
[Ys2, Ts2] = step(G2);

% récupère la réponse impulsionnelle
[Yt2, Tt2] = impulse(G2);

% affiche la réponse indicielle
rep_indicielle_g2 = subplot(height, column, 3);

% stepplot(rep_indicielle_g2, G2);
stepplot(rep_indicielle_g2, G2);
title(rep_indicielle_g2, 'Réponse indicielle G2(s)');

% affiche la réponse impulsionnelle
rep_impulsionnelle_g2 = subplot(height, column, 4);

impulseplot(rep_impulsionnelle_g2, G2);
title(rep_impulsionnelle_g2, 'Réponse impulsionnelle G2(t)');

%% Comparaisons
% inditielle
rep_ind_comp = subplot(height, column, 5);
stepplot(rep_ind_comp, G, 'b', G2, 'r--')
title(rep_ind_comp, 'Comparaison des réponses indicielles');
legend('G', 'G2');

% impulsionnelle
rep_impuls_comp = subplot(height, column, 6);
impulseplot(rep_impuls_comp, G, 'b', G2, 'r--')
title(rep_impuls_comp, 'Comparaison des réponses impulsionnelles');
legend('G', 'G2');
