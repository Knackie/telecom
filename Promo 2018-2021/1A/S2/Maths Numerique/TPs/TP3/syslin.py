# module pour LU
import numpy as np

def exercice1():
    """retourne la matrice, le second membre et la solution du systeme lineaire de l'exercice 1"""
    # on suppose que numpy est importe sous le nom np (import numpy as np)
    A = np.array([[1,2,3,4],[1,4,9,16],[1,8,27,64],[1,16,81,256]],float)
    b = np.array([2,10,44,190],float)
    x = np.array([-1,1,-1,1],float)
    return A,b,x

def lu_fact1(A):
    # version non vectorisee
    # A est une matrice n x n dont on calcule
    # la factorisation LU simple
    # on renvoie 2 objets: le tableau LU qui
    # contient la factorisation de maniere compacte
    # et un entier donnant le statut de calcul
    # istat = -1 si A n'est pas carree (NB: neanmoins on pourrait effectuer
    #            une factorisation sur une matrice rectangulaire)
    #          0 OK
    #          k > 0 : le pivot naturel a l'etape k est nul
    LU = A.copy()
    n,m = np.shape(A)
    if n != m:
        istat = -1
    else:
        istat = 0
        for k in range(n-1):
            if LU[k,k] == 0:
                istat = k+1
                break
            for i in range(k+1,n):
                LU[i,k] = LU[i,k]/LU[k,k]
                for j in range(k+1,n):
                    LU[i,j] = LU[i,j] - LU[i,k]*LU[k,j]
    return LU, istat

def lu_fact(A):
    # version vectorisee
    # A est une matrice n x n dont on calcule
    # la factorisation LU simple
    # on renvoie 2 objets: le tableau LU qui
    # contient la factorisation de maniere compacte
    # et un entier donnant le statut de calcul
    # istat = -1 si A n'est pas carree (NB: neanmoins on pourrait effectuer
    #            une factorisation sur une matrice rectangulaire)
    #          0 OK
    #          k > 0 : le pivot naturel a l'etape k est nul
    LU = A.copy()
    n,m = np.shape(A)
    if n != m:
        istat = -1
    else:
        istat = 0
        for k in range(n-1):
            if LU[k,k] == 0:
                istat = k+1
                break
            LU[k+1:,k] = LU[k+1:,k]/LU[k,k]
            LU[k+1:,k+1:] = LU[k+1:,k+1:] - np.outer(LU[k+1:,k],LU[k,k+1:])
    return LU, istat

def lu_solve1(LU,b):
    # version non vectorisee
    # resoud Ax=b connaissant la factorisation LU de A
    y = b.copy()
    n = len(y)
    # resolution de Ly = b
    for i in range(n):
        for j in range(i):
            y[i] = y[i] - LU[i,j]*y[j]
    # resolution de Ux = y
    x = y   # pas de copie juste un nouveau nom...
    for i in range(n-1,-1,-1):
        for j in range(i+1,n):
            x[i] = x[i] - LU[i,j]*x[j]
        x[i] = x[i]/LU[i,i]
    return x

def lu_solve(LU,b):
    # version vectorisee
    # resoud Ax=b connaissant la factorisation LU de A
    y = b.copy()
    n = len(y)
    # resolution de Ly = b
    for i in range(n):
        y[i] = y[i] - sum(LU[i,:i]*y[:i])
    # resolution de Ux = y
    x = y
    for i in range(n-1,-1,-1):
        x[i] = (x[i] - sum(LU[i,i+1:]*x[i+1:]))/LU[i,i]
    return x



