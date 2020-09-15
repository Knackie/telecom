function [ classe,I,C ] = hmeans( P,K )
[classe,C,I]=partition_init(P,K); %première partition
i=0;
visu_classe(P, classe, C, I, i);
pause
while 1
    [C] = barycentrage(P,classe,K); %on récupère le barycentre
    [newClasse,I]=affectation(P,C); %on récupère la nouvelle classe due au barycentre
    i=i+1;
    visu_classe(P, classe, C, I, i);
    pause
    if isequal(classe,newClasse) %on arrete si les classes ne changent plus
        break;
    end
    classe=newClasse; % sinon on recommence jusqu'à avoir la bonne
end
