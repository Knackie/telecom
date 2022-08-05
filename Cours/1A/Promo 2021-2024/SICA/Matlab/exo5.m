% Script construction de la matrice exercice 5
n = 5;
A=diag(2*ones(n,1), 0) - diag(1*ones(n-1,1),1) - diag(1*ones(n-1,1),-1);
disp(A);

