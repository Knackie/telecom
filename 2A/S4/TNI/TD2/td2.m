
%exo 1
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
figure(1);
colormap(lut2);
%lut en escalier : requantification

%eight
[J,lut3]= imread('eight.tif');
figure(1);
colormap(lut3);
figure(2);
plot(lut3);
%pièce foncée sur fond clair ?-> windows visualise le fichier au travers de
%la lute, linformation réel est pièce foncée sur fond clair.
figure(3);
image(J);
colormap(lut2);
lut4 = 1 - lut3;
figure(2);
%figure 2 en 256 niveau de gris
plot(lut4);
figure(1);
colormap(lut4);
figure(4);
%figure 4 en 64 niveaux de gris
image(I);
colormap(lut2);

I=imread('mire_nb.tif');
image(I);
colormap(lut4);