n = 49; 
T = ones(1,n); 
for k = 2:sqrt(n) 
    if T(k)==1 
        T(2*k:k:n)=0; 
    end 
end 
find(T) 
