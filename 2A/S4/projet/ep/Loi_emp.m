function [X] = Loi_emp(P)
F=[];
F(1)=P(1); 
n=length(P);
for i=2:n
   F(i)=F(i-1)+P(i);
end
index=[];
u=rand; 
index=find(F>u);
X = index(1);
end