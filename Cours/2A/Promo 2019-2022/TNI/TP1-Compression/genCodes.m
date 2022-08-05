%% genCodes.m
%% Creates a coding sequence for a set of probabilities

function [codes, lengths] = genCodes(probs)

n = size(probs);
n = n(1,2);

probs = [probs' zeros(n,1)];

moves = zeros(n-1,4);
min1 = [1.0 0];
min2 = [1.0 0];

%% Execute for n-1 moves
for move=1:n-1

  %% Calculate first minimum
  %% Get minimum from x probs
  [baseMin(1,1), baseMin(1,2)] = min(probs(:,1));

  %% Get minimum from move probs
  if (move < 2)
    moveMin = [1,0];
  else
    [moveMin(1,1), moveMin(1,2)] = min(moves(1:move-1,1));
  end
  
  %% Take minimum of the two
  if (baseMin(1,1) > moveMin(1,1))
    min1 = moveMin;
    moves(min1(1,2),1) = 1;
    moves(min1(1,2),2) = move;
  else
    min1 = baseMin;
    probs(min1(1,2),1) = 1;
    probs(min1(1,2),2) = move;
  end

  %% Calculate second minimum
  %% Get minimum from x probs
  [baseMin(1,1), baseMin(1,2)] = min(probs(:,1));

  %% Get minimum from move probs
  if (move < 2)
    moveMin = [1,0];
  else
    [moveMin(1,1), moveMin(1,2)] = min(moves(1:move-1,1));
  end
  
  %% Take minimum of the two
  if (baseMin(1,1) > moveMin(1,1))
    min2 = moveMin;
    moves(min2(1,2),1) = 1;
    moves(min2(1,2),2) = move;
  else
    min2 = baseMin;
    probs(min2(1,2),1) = 1;
    probs(min2(1,2),2) = move;
  end

  moves(move, 1) = min1(1,1) + min2(1,1);
  moves(move, 3) = min1(1,2);
  moves(move, 4) = min2(1,2);
end

moves(n-1,2) = 0;


%% Count number of moves for each ascii character

lengths = zeros(1,n);
codes = zeros(1,n);

for j=1:n
  count = 0;
  index = probs(j,2);
  code = 0;

  oldIndex = j;
  
  while (index > 0)
    if (moves(index,3) == oldIndex)
      code = code + 2^count;
    end

    oldIndex = index;
    index = moves(index,2);
    count = count+1;
  end

  lengths(1,j) = count;
  codes(1,j) = code;
end



