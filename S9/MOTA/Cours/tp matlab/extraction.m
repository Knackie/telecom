% FONCTION TATOUAGE (extraction) selon l'alorithme LSB
% fonctionne pour une image à niveau de gris M (message) à extraire d'une autre image
% à niveau de gris I_tatouée
% tous les bits de tous les pixels de M sont extraits de I par simple
% lecture séquentielle des bits de poids faible de tous les pixels de
% I_tatouée

function message2D = extraction(I_tatouee,nbl_msg,nbc_msg)


[nbl_I_tatouee, nbc_I_tatouee]=size(I_tatouee);
message1D=zeros(1,nbl_msg*nbc_msg); % création d'un vecteur pour recevoir 
% séquentiellement les pixels reconstitués à partir de séquences de 8 bits extraits de 8 pixels tatoués
message2D=zeros(nbl_msg,nbc_msg); %création d'une matrice pour remettre au format 2D message1D
offset=1; % offset
res=0;
k=1;
indice=128;



for i=1:nbl_I_tatouee
    for j=1:nbc_I_tatouee
        if k<=(nbl_msg*nbc_msg)     
            
            if offset==8
                m=I_tatouee(i,j); %lecture du pixel tatoué
                b=bitand(m,1);
                res=res+(b*indice);
                message1D(1,k)=res; % on écrit le pixel reconstitué dans message1D
                indice=128;
                offset=1;
                res=0;
                k=k+1;
                
                
            else
                m=I_tatouee(i,j); %lecture du pixel tatoué
                b=bitand(m,1); % récupération du bit de poids faible
                res=res+(b*indice);
                indice=indice/2;
                offset=offset+1;
                   
            end
          
        end
    end
end



%Réécriture en 2D
k=1;
for i=1:nbl_msg
    for j=1:nbc_msg
        message2D(i,j)=message1D(1,k);
        k=k+1;
    end
end



        
        
      
