import numpy as np
from numpy import array


def resout_tri_inf(T,b):
    n = len(b)
    x = np.zeros_like(b)
    for i in range(0,n):
        somme = 0
        for j in range(0,i-1):
            somme += T[i,j] * x[j]
        x[i] = (b[i] - somme) / T[i,i]
    return x


def fabrique_mat_newton(x):
    n = np.size(x)
    N = np.zeros([n,n])
    print("n ; ", n)
    for i in range(0, n):
        N[i,0] = 1
        for j in range(1,i+1):
            N[i,j] = N[i, j-1] * (x[i] - x[j-1])
    return N


def horner(t,x,c):
    n = np.size(x)
    p = c[n-1]
    for i in range(n-2, -1, -1):
        p = c[i] + (t - x[i]) * p
    return p


x = np.array([0,1,2,3])
c = np.array([1,-1, 1, -1])

def honorer_v(tt, x, c):
    n = np.size(tt)
    res = np.zeros_like(tt)
    for i in range(0, n):
        res[i] = horner(tt[i], x, c)
    return res

def cosa(x):
    return np.cos(x) * np.exp(-x / 4)