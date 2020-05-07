function [C] = barycentrage (X,classe,K)
[n,p]=size(X); %on r�cup�re la taille de X
C=zeros(K,p); %on cr�e une matrice remplie de 0
ne=zeros(K,1); %et un vecteur colonne rempli de 0
for i=1:n
    k=classe(i); %on r�cup�re la valeur n�i de la classe 
    C(k,:)=C(k,:)+X(i,:); %on ajoute les coordonn�es � la somme
    ne(k)=ne(k)+1; %le compteur de nombre de points est incr�ment�
end
for k=1:K
    C(k,:)=C(k,:)/ne(k); %on r�cup�re les coorodonn�es du barycentre et 
    %on les rentre dans C
end