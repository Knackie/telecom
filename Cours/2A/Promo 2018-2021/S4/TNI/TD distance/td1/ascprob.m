%% ascprob.m
%% Reads an ascii file and calculates the probability that an
%%   ascii character occurs

function [normProbs, Length] = ascprob(fileName)

%% File name to read, change to function arg later
stringLeng = 1024;

%% Open & reset file
file = fopen(fileName, 'r');
frewind(file);

gotten = 50;
codeProbs = zeros(1,128);

while (~feof(file))
  [curString gotten] = fread(file, 50, 'char');

  for j=1:gotten
    codeProbs(1,curString(j,1)+1) = codeProbs(1,curString(j,1)+1) + 1;
  end
end

%% Run the calculations
Length = sum(codeProbs);
normProbs = codeProbs./Length;

fclose(file);
