function [classe,C,I]=partition_init(P,K)
[x d]=size(P); %on r�cup�re la taille de P
C=zeros(K,d); % on cr�e C � 0
ind=tirer_entiers_tous_distincts(x,K); %on tire des indices al�atoires tous distincts
for i=1:length(ind)
   C(i,:)=P(ind(i),:);  %on met les valeurs dans C
end
[classe I]=affectation(P,C); %utilisation de affectation pour avoir les classes et les inerties