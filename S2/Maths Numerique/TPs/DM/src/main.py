#!/usr/bin/env python3
# -*- coding: utf8 -*-

import sys

from matplotlib.pyplot import loglog, show
from numpy import logspace, sqrt


def exercice1():
    x = 0.2
    print(x)
    fmt = "56.54f"
    print(format(x, fmt))


def exercice2(beta, p, emax):
    M = beta ** (emax + 1) - beta ** (emax + 1 - p)
    MBarre = (M + beta ** (emax + 1)) // 2
    return M, MBarre

def exercice3():
    n = 2000
    x = logspace(-20, -1, n)
    y1 = sqrt(1 + x) - sqrt(1 - x)
    y2 = 2 * x / (sqrt(1+x) + sqrt(1-x))
    ea = abs(y1 - y2)
    er = ea / abs(y2);
    erabs = 3 * sys.float_info.epsilon / abs(x)
    loglog(x[ea>0], er[ea>0])
    loglog(x,erabs)
    print(ea)
    show()

if __name__ == '__main__':
    fonction = 2
    if fonction == 0:
        exercice1()
    elif fonction == 1:
        Beta = 2
        p = 53
        emax = 1023
        (M, Mbarre) = exercice2(Beta, p, emax)
        print("Depuis le fonction :\n  M : ", M, "\n  Mbarre : ", M)
        M = sys.float_info.max
        print("On a donc M : ", M)
        M = int(M)
        print("On obtient ensuite : ", M)
        ##Mbarre = float(Mbarre)
        float(Mbarre - 1)
        print("Mbarre en double : ", Mbarre)
    elif fonction == 2:
        exercice3()
