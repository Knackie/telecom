[I,lut2]= imread('lena.tif');
A= [1/9,1/9,1/9;1/9,1/9,1/9;1/9,1/9,1/9];

%I = imnoise(I, 'salt & pepper', 0.1)
imshow(I);
figure
imshow(uint8(fonction_lissage(I,A)));

%carr� 
[I,lut2]= imread('Carr�1.tif');
Est = [-1,0,1;-1,0,1;-1,0,1];
Nord = [1,1,1;0,0,0;-1,-1,-1];
figure
imshow(uint8(abs(fonction_lissage(I,Est))));
    