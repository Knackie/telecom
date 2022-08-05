from asyncio.windows_events import NULL
import time
import numpy as np


"""
1er niveau de factorisation pour lu_fact + vectorisation pour lu_solve
    => + loin c'est l'utilisation de rentrées spécialisées
    Accélération d'un facteur entre 3 et ?
    
"""

# Produit matriciel @
def lu_fact(A):
    """ 
    A est une matrice (n,n) dont on calcule
      la factorisation LU simple.

    Retourne
      * le tableau LU qui contient la factorisation de maniere compacte
      * un entier donnant le statut de calcul
        -1 si A n'est pas carree (noter qu'il est possible de
           conduire une factorisation sur une matrice rectangulaire)
         0 si la factorisation se passe (a priori) bien
         k > 0 si le pivot naturel à l'étape k est nul.
    """
    n,m = np.shape(A)
    
    if n != m:
        return NULL,-1
    else:
        LU = A.copy()
        for k in range(0, n):
            if LU[k,k] == 0:
                return NULL,k+1
            for i in range(k+1, n):
                LU[i,k] = LU[i,k]/LU[k,k]
                for j in range(k+1, n):
                    LU[i,j] = LU[i,j]-LU[i,k]*LU[k,j]
    return LU,0
    
def lu_fact_vect(A):
    """
    A est une matrice (n,n) dont on calcule
      la factorisation LU simple.

    Retourne
      * le tableau LU qui contient la factorisation de maniere compacte
      * un entier donnant le statut de calcul
        -1 si A n'est pas carree (noter qu'il est possible de
           conduire une factorisation sur une matrice rectangulaire)
         0 si la factorisation se passe (a priori) bien
         k > 0 si le pivot naturel à l'étape k est nul.
    """
    LU = A.copy()
    n = A.shape[0]
    for k in range(n):
        if LU[k,k] == 0:
            return LU, k
        for i in range(k+1,n):
            LU[i,k] = LU[i,k]/LU[k,k]
            LU[i,k+1:n] -= LU[i,k]*LU[k,k+1:n]
    return LU, 0

def lu_solve_vect(LU,b):
    y = b.copy()
    n = len(b)
    # Ly = b
    for i in range(1,n):
        y[i] -= LU[i,:i]@y[:1]
    # Ux = y
    x = np.zeros(n)
    for i in range(n,-1,-1):
        temp = 0
        for j in range(i+1, n):
            temp += LU[i,j]*x[j]
        x[i] = (y[i]-temp)/LU[i,i]
    
def donnees_exercice3_td2():
    """
    Retourne (cf exercice 3 td2) : 
        * la matrice A
        * le second membre b 
        * la solution x du système Ax=b
        * les facteurs L et U (A = LU)
    """
    A = np.array([[1,2,3,4],[1,4,9,16],[1,8,27,64],[1,16,81,256]],float)
    b = np.array([2,10,44,190],float)
    x = np.array([-1,1,-1,1],float)
    L = np.array([[1,0,0,0],[1,1,0,0],[1,3,1,0],[1,7,6,1]],float)
    U = np.array([[1,2,3,4],[0,2,6,12],[0,0,6,24],[0,0,0,24]],float)
    return A, b, x, L, U

def test1_lu_fact():
    A,_,_,L,U = donnees_exercice3_td2()
    LU, statut = lu_fact(A)
    n,m = np.shape(A)
    LL = np.eye(n,m) + np.tril(LU,-1)
    UU = np.triu(LU)
    assert statut == 0
    assert np.allclose(L,LL)
    assert np.allclose(U,UU)
    err_LL = np.sum(abs(L-LL))/np.sum(abs(L))
    err_UU = np.sum(abs(U-UU))/np.sum(abs(U))
    print("Erreur L = {:.32f}".format(err_LL))
    print("Erreur U = {:.32f}".format(err_UU))

def test2_lu_fact(n):
    tic = time.time()
    A = np.random.randn(n,n)
    ii = np.arange(n)
    A[ii,ii] = 0
    A[ii,ii] = np.sum(abs(A),axis=1)+1
    LU, statut = lu_fact(A)
    tac = time.time()
    print(format(tac-tic))
    return A

# Méthode version Clément
def lu_solve(LU,b):
    """
    Retourne la solution du système Ax = b où LU est la
    factorisation (en stockage compact) LU de la matrice A
    (obtenue à l'aide de la fonction lu_fact).
    """
    n = LU.shape[0]
    y = np.zeros(n)
    
    # On trouve y 
    for i in range(n):
        y[i] = b[i]
        for j in range(i):
            y[i] = y[i] - LU[i,j]*y[j]
            
    x = np.zeros(n)
    
    # On trouve x à l'aide de y
    for i in range(n-1,-1,-1):
        x[i] = y[i]
        for j in range(i+1,n):
            x[i] = x[i] - LU[i,j]*x[j]
        x[i] = x[i]/LU[i,i]
    return x

# Correction de la méthode
def lu_solve_v2(LU,b):
    n = len(b)
    y = np.zeros(n)

    # résolution de Ly = b
    for i in range(n):
        temp = 0
        for j in range(i):
            temp += LU[i,j]*y[j]
        y[i] = b[i] - temp
    print(y)
    # résolution de Ux = y
    x = np.zeros(n)
    for i in range(n-1,-1,-1):
        temp = 0
        for j in range(i+1,n):
            temp += LU[i,j]*x[j]
        x[i] = (y[i] - temp)/LU[i,i]

    return x

def test1_lu_solve():
    A, b, x, _, _ = donnees_exercice3_td2()
    LU, _ = lu_fact(A)
    xx = lu_solve(LU,b)
    assert np.allclose(x,xx)

if __name__ == '__main__':
    # Pour exécuter les tests
    #test1_lu_fact()
    test2_lu_fact(100)
    #test1_lu_solve()

#for k in range(n-1):
   # for i in range(k+1,n):
  #      LU[i,k] = LU[i,k]/LU[k,k]
 #       for j in range(k+1, n):
#            LU[i,j] -= LU[i,k]*LU[k,j]
    