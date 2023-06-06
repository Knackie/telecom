function [I_med] = median(I)

[row col] = size(I);
I_med = I;
Z = imnoise(I_med,'salt & pepper')
voisin = zeros(3,3);
for i = 2:row-1
    for j = 2:col-1
    voisin = [I_med(i-1,j-1) I_med(i-1,j) I_med(i-1,j+1)... 
        I_med(i,j-1) I_med(i,j) I_med(i,j+1)... 
        I_med(i+1,j-1) I_med(i+1,j) I_med(i+1,j+1)];
   Res = sort(double(voisin(:)));
   J(i,j) = Res(5);
    end

end
J(1,:) = J(2,:);
J(col,:) = J(col-1);
J(:,1) = J(:,2);
J(:,row) = J(:,row-1);
figure(1); imshow(uint8(Z))
figure(2); imshow(uint8(J))
figure(3); imshow(uint8(I_med))

end
