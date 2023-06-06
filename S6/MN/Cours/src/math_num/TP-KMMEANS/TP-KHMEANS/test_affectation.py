"""test pour la fonction affectation"""

from hmeans import *
import numpy as np

np.random.seed(7)
C = np.array([[-1,0],
              [1,0],
              [0,2]])
sigma_K = [3, 4, 5]
n_K = [150, 110, 70]

X = fabrique_donnees(C, sigma_K, n_K)

classe, I = affectation(X, C)
classe_ref, I_ref = affectationv(X, C)

if np.all(classe == classe_ref):
    print("test affectation (classe) : OK")
else:
    print("test affectation (classe) : pas OK")

if np.allclose(I, I_ref):
    print("test affectation (inerties) : OK")
else:
    print("test affectation (inerties) : pas OK")


