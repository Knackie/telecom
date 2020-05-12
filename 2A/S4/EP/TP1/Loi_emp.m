function [X] = Loi_emp(P,Z)
%% Génération d'une V.A selon une loi empirique: X={1,2,...,n}
% P: vecteur de taille n representant la loi empirique de X
% 
F=[];
%F=cumsum(P); 
%%
F(1)=P(1); 
n=length(P);
for i=2:n
   F(i)=F(i-1)+P(i);
end
%%
index=[];
u=rand; % Génération d'une AV
index=find(F>u);
X=Z(index(1));
end