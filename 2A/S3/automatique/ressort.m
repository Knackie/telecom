s = tf('s');
m = 10;
k = 0.1;
f = 0.1;
tr1 = 1 / (m * s^2 + f * s + k );
tr2 = 1 / (m * s^2 + k);
impulse(tr1);
