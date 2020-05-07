function [ classe,I ] = affectation( P,C )
[K,p] = size(C); %on récupère la taille de C
[n,p] = size(P); %on récupère la taille de P
uns = ones (K,1); %on crée un vecteur colonne de longueur K rempli de 1
I = zeros(K,1); %on crée l'équivalent rempli de 0
for i=1:n
    d2 = sum((C-uns*P(i,:)).^2,2); %on fait la somme des distances au carré (inerties)
    [dmin,hmin]=min(d2); %on prend la somme des inerties minimale et le h correspondant
    classe(i)=hmin; %on ajoute cette valeur dans la classe
    I(hmin)=I(hmin)+dmin; %on met à jour l'inertie totale
end