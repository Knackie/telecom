%% codeStr.m
%% Returns a binary string conversion

function [outString] = codeStr(code, length)

outString = zeros(1, length);

for j=1:length
  bit = rem(code, 2);
  code = fix(code/2);

  outString(1, length-j+1) = bit + 48;
end