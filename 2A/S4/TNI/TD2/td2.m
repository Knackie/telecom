%pour charger l'image
[I,lut2]= imread('lena.tif');
%ici 256x256, UINT8 -> 0 to 255 max, 
%ici 25 min, 241 max.
image(I);
%affichage
figure(1);
%fonction qui affiche table de transfert sur 3 cannaux.
colormap('gray');
%image claire car 
%pour retirer le jaune
lut1=colormap;
%affichage lut1
figure(2);
%affichage nvx gris
plot(lut1);
hold on
plot(lut2);