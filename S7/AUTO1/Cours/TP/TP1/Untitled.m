%% L'automatique en MathLab
% G(s) = K/(1+sT)
% K = 10;
% T = 2
%
% -> Trouver la r�ponse indcielle G(s)
% ->          "     "   impulsionnelle de G(s)
% Commentaires
%
% G2(s) = K / [(1+sT)(1+s(T/10))]
% M�me chose pour G2(s)
% Comparer les r�ponses 
% 
% Aide : utiliser les fonctions tf(), step, impulse
% methode(F) permet d'afficher tout ce qui est applicable � F


K = 10;
T = 2;

%s = 1:0,1:10;

%% D�claration de la fonction de transfert : 

F = tf([2 1],[1 2]);

s = tf('s');
F1 = (2*s+1)/ (s+2);
F.num;
F.den;
get(F);

%%

G = K / (1+s *T);
%step(G);

G2 = K / (1 + s * T)*(1 + s * (T/10));
step(G,G2);
