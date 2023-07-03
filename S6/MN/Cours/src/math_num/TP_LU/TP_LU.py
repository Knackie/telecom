import numpy as np
import time

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
    LU = A.copy()
    n = A.shape[0]
    for k in range(n):
        if LU[k,k] == 0:
            return LU, k
        for i in range(k+1,n):
            LU[i,k] = LU[i,k]/LU[k,k]
            for j in range(k+1,n):
                LU[i,j] = LU[i,j] - LU[i,k]*LU[k,j]
    return LU, 0


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
    """
    test la fonction lu_fact avec les donnees
    retournees par la fonction donnees_exercice3_td2
    """
    A, b, x, L, U = donnees_exercice3_td2()
    LU, statut = lu_fact(A)
    LL = np.eye(4,4) + np.tril(LU,-1)
    UU = np.triu(LU)
    assert statut == 0
    assert np.allclose(L,LL)
    assert np.allclose(U,UU)
    err_LL = np.sum(abs(L-LL))/np.sum(abs(LL))
    err_UU = np.sum(abs(U-UU))/np.sum(abs(UU))
    print("Erreur L = {:.32f}".format(err_LL))
    print("Erreur U = {:.32f}".format(err_UU))



def lu_solve(LU,b):
    tic = time.time()
    """
    Retourne la solution du système Ax = b où LU est la
    factorisation (en stockage compact) LU de la matrice A
    (obtenue à l'aide de la fonction lu_fact).
    """
    n = LU.shape[0]
    y = np.zeros(n)
    for i in range(n):
        y[i] = b[i]
        for j in range(i):
            y[i] = y[i] - LU[i,j]*y[j]
    x = np.zeros(n)
    for i in range(n-1,-1,-1):
        x[i] = y[i]
        for j in range(i+1,n):
            x[i] = x[i] - LU[i,j]*x[j]
        x[i] = x[i]/LU[i,i]
    tac = time.time()
    print(format(tac-tic))
    return x

def lu_solve_V3(LU,b):
    """
    Retourne la solution du système Ax = b où LU est la
    factorisation (en stockage compact) LU de la matrice A
    (obtenue à l'aide de la fonction lu_fact).
    """
    tic = time.time()
    #pdb.set_trace()
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
    tac = time.time()
    print(format(tac-tic))
    return x

# Correction de la méthode par le prof
def lu_solve_v2(LU,b):
    tic = time.time()
    n = len(b)
    y = b.copy()
    
    # résolution de Ly = b
    for i in range(1,n):
        temp = 0
        for j in range(i):
            temp += LU[i,j]*y[j]
        y[i] = temp

    # résolution de Ux = y
    x = np.zeros(n)
    for i in range(n-1,-1,-1):
        temp = 0
        for j in range(i+1,n):
            temp += LU[i,j]*x[j]
        x[i] = (y[i] - temp)/LU[i,j]
    tac = time.time()
    print(format(tac-tic))
    return x

def test1_lu_solve():
    """
    fonction qui permet de tester la fonction lu_solve
    """
    # test avec les donnees de l'exercice 3
    A, b, x, L, U = donnees_exercice3_td2()
    LU, statut = lu_fact(A)
    x = lu_solve_V3(LU,b)
    assert np.allclose(x,x)

def testsuite(n):
    tic = time.time()
    A = np.random.randn(n,n)
    ii = np.arange(n)
    A[ii,ii] = 0
    A[ii,ii] = np.sum(abs(A),axis=1)+1
    tac = time.time()
    print(format(tac-tic))
    return A

if __name__ == '__main__':
    test1_lu_fact()
    test1_lu_solve()