import time
import numpy as np

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


def lu_fact_vect2(A):
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
        LU[k+1:n,k] /= LU[k,k]
        LU[k + 1:n, k + 1:n] -= np.outer(LU[k+1:n,k],LU[k,k+1:n])
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

def test1_lu_fact_vect():
    """
    test la fonction lu_fact avec les donnees
    retournees par la fonction donnees_exercice3_td2
    """
    A, b, x, L, U = donnees_exercice3_td2()
    LU, statut = lu_fact_vect(A)
    LL = np.eye(4,4) + np.tril(LU,-1)
    UU = np.triu(LU)
    assert statut == 0
    assert np.allclose(L,LL)
    assert np.allclose(U,UU)
    err_LL = np.sum(abs(L-LL))/np.sum(abs(LL))
    err_UU = np.sum(abs(U-UU))/np.sum(abs(UU))
    print("Erreur L = {:.32f}".format(err_LL))
    print("Erreur U = {:.32f}".format(err_UU))

def mat_diag_dom(n):
    """
    renvoie une matrice A à diagonale dominante
    """

    A = np.random.randn(n,n)
    ii = np.arange(n)
    A[ii,ii] = 0
    A[ii,ii] = np.sum(abs(A), axis=1) + 1
    return A

def lu_solve(LU,b):
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
    return x


# Correction de la méthode par le prof
def lu_solve_v2(LU, b):
    n = len(b)
    y = b.copy()

    # résolution de Ly = b
    for i in range(1, n):
        temp = 0
        for j in range(i):
            temp += LU[i, j] * y[j]
        y[i] = temp

    # résolution de Ux = y
    x = np.zeros(n)
    for i in range(n - 1, -1, -1):
        temp = 0
        for j in range(i + 1, n):
            temp += LU[i, j] * x[j]
        x[i] = (y[i] - temp) / LU[i,i]

    return x

# Correction de la méthode par le prof : vectorisation
def lu_solve_v3(LU, b):
    n = len(b)
    y = b.copy()

    # résolution de Ly = b
    for i in range(1, n):
        y[i] -= LU[i,0:i]@y[0:i]

    # résolution de Ux = y
    x = np.zeros(n)
    for i in range(n - 1, -1, -1):
        temp = LU[i,i+1:n]@x[i+1:n]
        x[i] = (y[i] - temp) / LU[i, i]

    return x

def test1_lu_solve():
    """
    fonction qui permet de tester la fonction lu_solve
    """
    # test avec les donnees de l'exercice 3
    A, b, x, L, U = donnees_exercice3_td2()
    LU, statut = lu_fact(A)
    x = lu_solve(LU,b)
    assert np.allclose(x,x)

def test2_lu_solve():
    """
    fonction qui permet de tester la fonction lu_solve
    """
    # test avec les donnees de l'exercice 3
    A, b, x, L, U = donnees_exercice3_td2()
    LU, statut = lu_fact(A)
    x = lu_solve(LU,b)
    err = np.sum(abs(A@x - b)) / np.sum(abs(b))
    print('Erreur relative solve :',err)
    assert np.allclose(x,x)

def time_testing(n):
    A = mat_diag_dom(n)
    t0 = time.time()
    for i in range(10):
        LU, istat = lu_fact(A)
        del LU
    texec = time.time()
    return (texec-t0)/10

def time_testing_vect(n):
    A = mat_diag_dom(n)
    t0 = time.time()
    for i in range(10):
        LU, istat = lu_fact_vect(A)
        del LU
    texec = time.time()
    return (texec-t0)/10

def time_testing_vect2(n):
    A = mat_diag_dom(n)
    t0 = time.time()
    for i in range(10):
        LU, istat = lu_fact_vect2(A)
        del LU
    texec = time.time()
    return (texec-t0)/10

if __name__ == '__main__':
    t1 = time_testing(50)
    print("Time testing :",t1)
    t2 = time_testing_vect(50)
    t3 = time_testing_vect2(50)
    print("Time fact :",t2)
    print("Time fact2 :",t3)
    print("Facteur pour n=50",t1/t2)
    print("Facteur 2 pour n=50",t1/t3)
    t1 = time_testing(100)
    print("Time testing :",t1)
    t2 = time_testing_vect(100)
    t3 = time_testing_vect2(100)
    print("Time fact :",t2)
    print("Time fact2 :",t3)
    print("Facteur pour n=100",t1/t2)
    print("Facteur 2 pour n=100",t1/t3)
    t1 = time_testing(200)
    print("Time testing :",t1)
    t2 = time_testing_vect(200)
    t3 = time_testing_vect2(200)
    print("Time fact :",t2)
    print("Time fact2 :",t3)
    print("Facteur pour n=200",t1/t2)
    print("Facteur 2 pour n=200",t1/t3)
    t1 = time_testing(400)
    print("Time testing :",t1)
    t2 = time_testing_vect(400)
    t3 = time_testing_vect2(400)
    print("Time fact :",t2)
    print("Time fact2 :",t3)
    print("Facteur pour n=400",t1/t2)
    print("Facteur 2 pour n=400",t1/t3)