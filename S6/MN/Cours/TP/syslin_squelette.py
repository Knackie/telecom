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
    pass

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
    pass

def lu_solve(LU,b):
    """
    Retourne la solution du système Ax = b où LU est la
    factorisation (en stockage compact) LU de la matrice A
    (obtenue à l'aide de la fonction lu_fact).
    """
    pass

def test1_lu_solve():
    pass


if __name__ == '__main__':
    # pour exécuter les tests
    pass
