import matplotlib.pyplot as mpl
import numpy as np

def phi1(x):
    return 1/(1+x)-1/(1-x)

def phi2(x):
    return -2*x/((1+x)*(1-x))


if __name__ == "__main__":
    n = 10000
    x = np.logspace(-18, -1, n)
    y1 = phi1(x)
    y2 = phi2(x)
    ea = abs(y1-y2) # Erreur absolue
    er = ea/abs(y2) # Erreur relative
    mpl.figure(1)
    mpl.clf()
    #mpl.loglog(x, er, "x")
    #mpl.loglog(x[ea>0], er[ea>0], "rx")
    mpl.loglog(x, er, "x", x, 2**(-53)/abs(x), "r")
    mpl.show()