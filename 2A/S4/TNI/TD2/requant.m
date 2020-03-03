function lut = requant(N)
lut = zeros(N, 3);
step=(256/N);

for k=2:N
   Tk = floor((k-1)*step);
   Rk = Tk * (N/(N-1));
   
   for j = Tk:Tk+step
       lut(j,1) = Rk;
       lut(j,2) = Rk;
       lut(j,3) = Rk;
   end
end
    lut=lut./256;
end


