function [ classe,I ] = affectation( P,C )
[K,p] = size(C); %on r�cup�re la taille de C
[n,p] = size(P); %on r�cup�re la taille de P
uns = ones (K,1); %on cr�e un vecteur colonne de longueur K rempli de 1
I = zeros(K,1); %on cr�e l'�quivalent rempli de 0
for i=1:n
    d2 = sum((C-uns*P(i,:)).^2,2); %on fait la somme des distances au carr� (inerties)
    [dmin,hmin]=min(d2); %on prend la somme des inerties minimale et le h correspondant
    classe(i)=hmin; %on ajoute cette valeur dans la classe
    I(hmin)=I(hmin)+dmin; %on met � jour l'inertie totale
end