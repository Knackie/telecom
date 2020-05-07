function [J] = dilatation(I)
%Z = imnoise(I,'salt & pepper')
[row col] = size(I);
I_dilatation = I;
voisin = zeros(3,3);
for i = 2:row-1
    for j = 2:col-1
    voisin = [I_dilatation(i-1,j-1) I_dilatation(i-1,j) I_dilatation(i-1,j+1)... 
        I_dilatation(i,j-1) I_dilatation(i,j) I_dilatation(i,j+1)... 
        I_dilatation(i+1,j-1) I_dilatation(i+1,j) I_dilatation(i+1,j+1)];
   Res = sort(double(voisin(:)));
   J(i,j) = Res(9);
    end

end
J(1,:) = J(2,:);
J(col,:) = J(col-1);
J(:,1) = J(:,2);
J(:,row) = J(:,row-1);
figure(2); imshow(uint8(J))
%figure(3); imshow(uint8(I_dilatation))

end
