from pylab import *

#import de votre module algebre lineaire

# donnees pour le probleme de la hauteur de la mousse de
# biere en fct du temps, issues de l'article :
# Demonstration of the exponential decay law using beer froth
# A Leike
# European Journal of Physics
# stacks.iop.org/EJP/23/21

# instants de mesure
tm = array([0,15,30,45,60,75,90,105,120,150,180,210,240,300,360],'double')

# hauteurs mesurees (pour la Erdinger Weissbier)
hm = array([17,16.1,14.9,14.0,13.2,12.5,11.9,11.2,10.7,9.7,8.9,8.3,7.5,6.3,5.2])

# erreurs sur les hauteurs
dhm = array([0.001,0.3,0.4,0.4,0.4,0.6,0.4,0.4,0.4,0.4,0.3,0.4,0.4,0.5,0.5])


