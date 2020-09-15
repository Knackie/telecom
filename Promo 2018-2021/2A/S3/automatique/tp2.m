%G(s) = 2 / s² + 0.1s + 1
s = tf('s');
G = 2/(s^2 + 0.1 * s + 1);
G1 = 2 / (s^2 + 0.5 *s + 1);
G2 = 2/ ( s^2  + 0.01 * s + 1); 
impulse(G)
step(G);
%amortissement
damp(G);
%oméga : pulsation propre 
% xi : taux d'amortissement
%gain statique
dcgain(G)  
pzmap(G,G1,G2)
%Comme la partie réelle est beaucoup plus petite sur G Que sur G1 alors
% elle oscillera moins.
