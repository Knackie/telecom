function [entropy] = entropy(img)
%UNTITLED3 Summary of this function goes here
[dim1,dim2] = size(img);
tmp = Histo(img);
tmp = tmp./(dim1*dim2);
tmp = tmp(tmp >0,:);
entropy = -sum(tmp.*log2(tmp));
end