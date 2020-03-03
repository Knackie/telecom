I=imread('lena.tif');
I = imnoise(I,'gaussian',0.01);
image(I);
lut5=requant(2);
colormap(lut5)
