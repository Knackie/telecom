# -*- coding: utf-8 -*-
"""
Created on Wed Mar 25 17:48:11 2015

@author: bruno
"""

# module d'interpolation
import numpy as np
from pylab import cos
from math import pi

def lagrange(t,x,y):
    """t : abscisse d'évaluation du polynôme d'interpolation
       x, y : points d'interpolation"""
    p = 0
    n = len(x)
    for i in range(n):
        Li = 1
        for j in range(n):
            if j != i :
                Li = Li * ((t-x[j]) / (x[i]-x[j]))
        p = p + y[i]*Li
    return p

def lagrange_v(tv,x,y):
    """tv : vecteur d'abscisses sur lesquelles on veut évaluer le polynome d'interpolation
       x, y : points d'interpolation"""
    pv = np.zeros(len(tv))
    m = len(pv)
    for k in range(m):
        pv[k] = lagrange(tv[k], x, y)
    return pv

def tchebichev(a,b,n):
    X = np.zeros(n)
    x = np.zeros(n)
    for i in range(0, n):
        X[i] = cos(((2 * i + 1) * pi) / (2 * n))
        x[i] = ((a+b) / 2) + ((b - a) / 2) * X[i]
    return x

def lagrange_poids_fb(x):
    w = np.ones(len(x))
    n = len(x)
    for i in range(0,n):
        for k in range(0, n):
            if k != i:
                w[i] = w[i] * (x[i] - x[k])
    return w

def lagrange_fb(t,x,y,w):
    ind = np.nonzero(x == t)
    if len(ind[0]) > 0:
        return y[ind[0][0]]
    else:
        num = 0
        den = 0
        n = len(x)
        for i in range(0, n):
            temp = ((t - x[i]) * w[i])
            num = num + (y[i] / temp)
            den = den + (1 / temp)
        return num / den