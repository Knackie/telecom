%% Huffman.m
%% Generates a huffman code for a given ascii file
%% Note: only defined for lower ascii set, use text files only
%% Use: huffman('filename'), FILENAME MUST BE IN QUOTES
%% Generates an output data file of same name with .out extension

function [probs, lengths] = huffman(inpFile)

%% Number of bits in ASCII code
bits = 7;

%% Probability output file
datafile = 'data.out';

%% Generate output file name
count = 0;
delimiter = 'a';

while (delimiter ~= '.')
  delimiter = inpFile(1,count+1);
  count = count + 1;
end
datafile = [inpFile(1,1:count) 'out'];

%% Get ascii probability data
[probs, length] = ascprob(inpFile);

%% Calculate character set entropy
h = entropy(probs, 2);

[code, lengths] = genCodes(probs);

L = probs*lengths';

%% Output data to file

file = fopen(datafile, 'w');
frewind(file);

fprintf(file, 'ASCII  Character  Probability   Length   Code\n\n');
for j=1:128
  fprintf(file, '%d    %c        %0.6f         %3d        %s\n', j-1, j-1, probs(1,j), lengths(1,j), codestr(code(1,j), lengths(1,j)));
end

fprintf(file, '\n\nFile length = %d\n', length);
fprintf(file, 'Entropy = %1.4f\n', h);
fprintf(file, 'Average code length = %1.4f\n', L);
fprintf(file, 'Compression ratio = %.4f\n', L/bits);
fprintf(file, 'Entropy ratio = %1.4f\n', L/h);

fclose(file);

figure(1);
bar(probs);
%% figure(2);
%% plot(lengths);

