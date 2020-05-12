function [X] = CMTC(P0, M, T)
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
n=size(M,1);
Q=[];
%%calcul de Q
for i=1:n
    Q(i,:)=M(i,:)/(-M(i,i));
    Q(i,i)=0;
end
%%generation état initial
X(1) = Loi_emp(P0);
S(1)=expo(-M(X(1),X(1)));
i=1
while(S(i)<T)
    X(i+1)=Loi_emp(Q(X(i),:));
    temp=expo(-M(X(i),X(i)));
    S(i+1)=S(i)+temp;
    i=i+1;
end
stairs(S,X);xlabel('Temps');ylabel('Etat');
end

