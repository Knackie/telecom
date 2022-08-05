# _*_ coding: utf-8 _*_

import numpy as np
from numpy.matlib import rand


def lu_fact(A):
    # A est une matrice n x n dont on calcule
    # la factorisation LU simple
    # on renvoie 2 objets: le tableau LU qui
    # contient la factorisation de maniere compacte
    # et un entier donnant le statut de calcul
    # istat = -1 si A n’est pas carree (noter qu’il est possible de
    #            conduire une factorisation sur une matrice rectangulaire)
    # 0 OK
    #          k > 0 : le pivot naturel a l’etape k est nul
    n, m = np.shape(A)
    LU = A.copy()
    if n != m:
        return LU, -1
    for k in range(0, n - 1):
        if LU[k, k] == 0:
            return LU, k
        for i in range(k + 1, n):
            LU[i, k] = LU[i, k] / LU[k, k]
            for j in range(k + 1, n):
                LU[i, j] = LU[i, j] - LU[i, k] * LU[k, j]
    return LU, 0


def lu_solve(LU, b):
    # resoud Ax=b connaissant la factorisation LU de A
    y = b.copy()
    n = len(y)
    for i in range(0, n):
        for j in range(0, i):
            y[i] = y[i] - LU[i, j] * y[j]
    x = np.zeros(n)
    for i in range(n - 1, -1, -1):
        x[i] = y[i]
        for j in range(i + 1, n ):
            x[i] = x[i] - LU[i, j] * x[j]
        x[i] = x[i] / LU[i, i]
    return x


def exercice3():
    """retourne la matrice, le second membre et la solution du systeme lineaire de l’exercice 3"""
    # on suppose que numpy est importe sous le nom np (import numpy as np)
    A = np.array([[1, 2, 3, 4], [1, 4, 9, 16], [1, 8, 27, 64], [1, 16, 81, 256]], float)
    b = np.array([2, 10, 44, 190], float)
    x = np.array([-1, 1, -1, 1], float)
    return A, b, x


if __name__ == "__main__":
    execution = 2
    if execution == 1:
        A = rand(4, 4)  # unematrice4x4avecdesr ́ealisationsind ́ependantesdeU(0,1)
        LU, istat = lu_fact(A)  # factorisation
        L = np.tril(LU, -1) + np.identity(4)  # reconstitution de L
        U = np.triu(LU)  # reconstitution de U
        print(A - np.dot(L, U))  # doit donner une matrice proche de 0
    elif execution == 2:
        A, b, xe = exercice3()
        LU, istat = lu_fact(A)
        x = lu_solve(LU, b)
        e = x - xe
        print(e)
