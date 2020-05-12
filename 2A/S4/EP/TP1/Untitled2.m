lambda = 20;
N = 100000;
X=[];
for i=1:N
    X(i) = expo(lambda);
end
moyenne = mean(X)
moyenne_theo=1/lambda
variance=var(X)
variance_theo=1/lambda^2

%X = Loi_emp([0.2 0.1 0.7])

