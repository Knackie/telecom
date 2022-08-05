function visu_classe(P, classe, C, I, num_iter)
%   dessin des classes
%   num_iter correspond au numéro de l'itération dans
%   les h_means (mettre 0 pour l'affichage de la partition
%   initiale)

K = max(classe);
if K > 6 
    disp(' le nb de classes est limité à 6')
    return
end 
sym = ['o', 'd', 'v', '^', '*', 'p'];
col = ['b', 'g', 'r', 'c', 'm', 'y'];
hold off
h=plot(C(:,1),C(:,2),'kx'); set(h,'MarkerSize',12); set(h,'LineWidth',2)
hold on
for i=1:K
    ind = find(classe == i);
    xi = P(ind,1); yi = P(ind,2);
    plot(xi,yi,strcat(col(i),sym(i)))
    hold on
    if length(xi) > 2
       iec = convhull(xi,yi);
       plot(xi(iec),yi(iec),col(i)) 
       hold on
   end
end
axis equal
title(strcat('Partition apr�s l''it�ration',sprintf(' %d ',num_iter),...
             ',  Inertie totale =',sprintf(' %g',sum(I))))
         
    
