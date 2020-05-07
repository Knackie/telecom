function [ H ] = tirer_entiers_tous_distincts( n,K )
H=ones(1,K);
X=1:n; %initialisation d'un vecteur contenant les valeurs de 1 � n
if(K>n) %condition d'erreur et message renvoy�
    disp('Erreur de saisie de valeurs: K<n'),
    H=[];
    return,
else %cas exploitable
    for k=1:K %pour chacune des K valeurs a renvoyer
        while(true) %tant que le r�sultat n'est pas bon on refait
            a=ceil(rand(1,1)*n); %g�n�ration d'un indice du tableau
            b=X(a); %on prend la valeur � l'indice
            X(a)=0; %on l'annule
            if b~=0 %si elle est non nulle on sort de la boucle infinie
                break,
            end
        end
        H(k)=b; %on place la valeur dans le vecteur de sortie
    end
end