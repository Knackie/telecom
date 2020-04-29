[I,lut2]= imread('souris.bmp');
entropy(I);

A = double(I); B = double(imnoise(I));
d = sum((A(:)-B(:)).^2) / prod(size(A));
psnr = 10*log10(255*255/d);