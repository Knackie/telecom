function [outputArg1] = fonction_lissage(input,m)
%UNTITLED2 Summary of this function goes here
%   Detailed explanation goes here
inputArg1=double(input);
outputArg1 = inputArg1;
[nb_ligne,nb_colonne] = size(inputArg1);
[m1,m2] = size(m);
for i = 2 : nb_ligne-1
    for j = 2 : nb_colonne-1
        outputArg1(i,j) = 0;
        for k = 1 : m1
            for l = 1 : m2
                outputArg1(i,j) = outputArg1(i,j) + m(k,l)*inputArg1(i+2-k,j+2-l);
            end
        end
    end
end
 outputArg1(:,1)=outputArg1(:,2);
    outputArg1(:,nb_colonne)=outputArg1(:,nb_colonne-1);
    
    outputArg1(1,:)=outputArg1(2,:);
    outputArg1(nb_ligne,:)=outputArg1(nb_ligne-1,:);
end

