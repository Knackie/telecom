clear all;
p = [1 -8 -32 -13];
q = [4 0 3];
r1 = conv(p, q);
r2 = deconv(p, q);
x = -5:0.01:12;

racines = roots(p);
y = polyval(p, x);
plot(x, y);
grid;
