from hmeans_squel import *
import numpy as np
import matplotlib.pyplot as plt

# on choisit de fabriquer 4 clusters de points 
n_K = [220, 90, 400, 133] # nb de points pas cluster
mu_K = [[-1,-1],          # centre des 4 clusters
        [-1, 1],
        [1, -1],
        [1, 1]]
sigma_K = [0.3, 0.2, 0.25, 0.18] # écart type pour la loi Normale

np.random.seed(5)  # on impose l'état du générateur aléatoire
X = fabrique_donnees(mu_K, sigma_K, n_K)

# affichage graphique
visu_donnees(X, n_K)
plt.title("4 clusters assez bien séparés")
plt.show()
