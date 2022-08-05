function [ classe,I,C ] = hmeans( P,K )
[classe,C,I]=partition_init(P,K); %premi�re partition
i=0;
visu_classe(P, classe, C, I, i);
pause
while 1
    [C] = barycentrage(P,classe,K); %on r�cup�re le barycentre
    [newClasse,I]=affectation(P,C); %on r�cup�re la nouvelle classe due au barycentre
    i=i+1;
    visu_classe(P, classe, C, I, i);
    pause
    if isequal(classe,newClasse) %on arrete si les classes ne changent plus
        break;
    end
    classe=newClasse; % sinon on recommence jusqu'� avoir la bonne
end
