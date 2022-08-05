"""test pour la fonction barycentrage"""

from hmeans import *
import numpy as np

np.random.seed(7)
mu_K = [[-1,0],
        [1,0]]
sigma_K = [0.5, 0.43]
n_K = [200, 110]

X = fabrique_donnees(mu_K, sigma_K, n_K)

classe = np.empty(310, dtype='int32')
classe[:200] = 0
classe[200:] = 1

K = 2
G = barycentrage(X, classe, K)
G_ref = barycentragev(X, classe, K)

if np.allclose(G,G_ref):
    print("test barycentrage : OK")
else:
    print("test barycentrage : pas OK")

