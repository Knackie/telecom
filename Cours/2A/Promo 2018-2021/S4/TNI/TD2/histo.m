function histo( I )
%HISTO Summary of this function goes here
%   Detailed explanation goes here

x=0:255;
y=zeros(256, 1);
[l,c]=size(I);

for i=1:l
   for j=1:c
        NgR=double(I(i,j);
        y(I(i,j))=y(I(i,j))+1;
        
   end
end

figure
bar(x,y);


end
