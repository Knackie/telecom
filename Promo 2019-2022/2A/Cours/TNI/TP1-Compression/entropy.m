%% entropy.m
%% Calculates an entropy for a probability distribution

function [H] = entropy(probs, ary)

n = size(probs);
n = n(1,2);

H = 0;

for j=1:n
  if (probs(1,j) > 0)
    H = H - probs(1,j)*(log(probs(1,j))/log(ary));
  end
end