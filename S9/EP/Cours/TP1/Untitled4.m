%% Partie 2
lambda=1000;
mu = 2000;
T=0.1;
M= ([-lambda mu; mu -mu])
P0 = [1 0];
X = CMTC(P0,M,T);