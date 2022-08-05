s=tf('s');
g=1/(s+2);
x=1/(s+1);
y=g*x;
[r,p,k] = residue(y.num{1},y.den{1});
%r = de
%p = pole
% k = partie entière
