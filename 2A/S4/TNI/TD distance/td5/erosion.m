function [J] = erosion(I)
%Z = imnoise(I,'salt & pepper')
[row col] = size(I);
I_erosion = I;
voisin = zeros(3,3);
for i = 2:row-1
    for j = 2:col-1
    voisin = [I_erosion(i-1,j-1) I_erosion(i-1,j) I_erosion(i-1,j+1)... 
        I_erosion(i,j-1) I_erosion(i,j) I_erosion(i,j+1)... 
        I_erosion(i+1,j-1) I_erosion(i+1,j) I_erosion(i+1,j+1)];
   Res = sort(double(voisin(:)));
   J(i,j) = Res(1);
    end

end
J(1,:) = J(2,:);
J(col,:) = J(col-1);
J(:,1) = J(:,2);
J(:,row) = J(:,row-1);
figure(2); imshow(uint8(J))
%figure(3); imshow(uint8(I_erosion))

end
