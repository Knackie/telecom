function [X S] = CMTC(P0,M, T)
%% Simulation d'une chaîne de Markov

% P0 = distribution empirique pour l'état initial
% M = Matrice de taux de transition
% T = Durée d'observation

n = size(M,1);
Q = [];
S = [];
X = [];

%% Calcul de Q

for i=1:n
    Q(i,:) = M(i,:)/(-M(i,i)); % M(i,i) <=> -lambda(i)
    Q(i,i) = 0;
end

%% Génération de l'état initial

X(1) = Loi_emp(P0); % Etat initial
% X(1) = 1;
S(1) = expo(-M(X(1), X(1))); % Temps de séjour pour l'état initial

i = 1;
while(S(i) < T)
    X(i+1) = Loi_emp(Q(X(i),:)); % Génération de l'état suivant
    temp = expo(-M(X(i+1), X(i+1)));
    S(i+1) = S(i) + temp;
    i = i+1;
end

% stairs(S,X); xlabel('Temps'); ylabel('Etat');
end