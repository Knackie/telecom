function [histo] = Histo(image)
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
tmp = zeros(max(image(:))+1,1);
[dim1,dim2] = size(image);
for i=1:dim1
    for j = 1:dim2
        tmp(double(image(i,j))+1)= tmp(double(image(i,j))+1) + 1;
    end
end
histo = tmp
end