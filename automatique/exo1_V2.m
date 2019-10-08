%
% Y(s) = K / 1+sT * 1/s ----> y(t)= K(1 -e^-t/T).1(t)
% Y(s) = G(s) * U(s)
% step considère que l'entrée est de 1/s

T = 2;
k = 10;
% fonction de transfere : 
G = tf([0 k],[T 1]);
U = tf([0 1] ,[ 1 0]);
impulse(G*U);
