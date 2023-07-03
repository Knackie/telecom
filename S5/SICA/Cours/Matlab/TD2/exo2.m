clear all;
close all;

% 1er methode => méthode du tableau x
% Initialisation
x = [1 2 3 4];
y = [5 4 3 2 1];
lx = length(x);
ly = length(y);
lz = lx + ly - 1;

x = [x zeros(1, lz-lx)];
y = [y zeros(1, lz-ly)];
z = zeros(1, lz); 

% Produit de convolution
for k=1:lz
    s=0;
    for n=0:k-1
        s = s + (x(n+1)*y(k-n));
    end
    z(k) = s;
end

% Comparaison 
z;
conv(x, y);

% 2e methode => par les domaines
X = fft(x, lz);
Y = fft(y, lz);

Z = X.*Y;

z2 = ifft(Z)
err = z-z2;
round(z2);

stem(z2);
grid();
title("Produit de convolution de x et y");