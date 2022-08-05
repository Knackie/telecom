# -*- coding: utf-8 -*-
"""
Created on Wed Mar 25 15:30:28 2015

@author: bruno
"""
from pylab import *    # tout numpy et pyplot
from interp_skeleton import *   # importation des fcts d'interpolation

n = 600                  # nb de points d'interpolation
a = -4; b = 4           # l'intervalle d'interpolation
m = 300                   # nb de points pour le trace des courbes
t = tchebichev(a, b, m)     # les abscisses pour le trace des courbes
x = tchebichev(a, b, n)     # les abscisses d'interpolation
y = 1 / (1 + (x*x))                # les ordonnees d'interpolation

# le calcul
p = lagrange_v(t,x,y)      # evaluation du polynome
s = 1 / (1 + (t * t))                 # evaluation de la fonction exacte
            
# calcul d'erreur et visu graphique
e = s - p
figure(0)
clf()
subplot(2,1,1)
plot(x, y, 'bo', t, p, 'r-', t, s, 'g-')
legend(("points d'interpolation","polynome d'interpolation","fonction exacte"),loc=1)
title('Interpolation de la fct sinus')

subplot(2,1,2)
plot(t, e, 'b-')
title("erreur d'interpolation : e(t)=1/(1+(t * t))-p(t)")
show()
