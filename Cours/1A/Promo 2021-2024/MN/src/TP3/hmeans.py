"""Classification par hmeans"""

import numpy as np
import matplotlib.pyplot as plt
import pdb

def fabrique_donnees(mu_K, sigma_K, n_K):
   """
   fabrication de données (2d) à classer par kmeans en utilisant
   K clusters dont on se donne les centres (mu_K), les écarts types
   (sigma_K) et le nombre de points par cluster (n_K). En fonction des 
   centres et des écarts types, on peut générérer des données bien séparées
   pas trop séparées, etc. Les points sont obtenus par une loi gausienne,
   pour le cluster k :

    (x,y) où x réalisation de mu_K[k,0] + sigma_K[k]* X, X ~ N(0,1)
          et y réalisation de mu_K[k,1] + sigma_K[k]* Y, Y ~ N(0,1) 

    mu_K : tableau (K,2) mu_K[k,:] centre du cluster k
    sigma_K : tableau (K) écart type de chaque cluster
    n_K : tableau (K) nb de points par cluster
    (K est le nombre de clusters désirés)

   retourne : 

    X : tableau (n, 2) où n = sum(n_K)
   """
   n = sum(n_K)
   X = np.empty((n,2))
   b0 = 0
   for k, nk in enumerate(n_K):
      b1 = b0 + nk
      X[b0:b1,0] = mu_K[k][0] + sigma_K[k]*np.random.randn(nk)
      X[b0:b1,1] = mu_K[k][1] + sigma_K[k]*np.random.randn(nk)
      b0 = b1
   return X           

def visu_donnees(X, nK, ax=None):
   """
   affiche les points obtenus par fabrique_données (7 couleurs 
   différentes seulement)
   """
   style = ["xb", "xg", "xr", "xm", "xy", "xc", "xk"]
   if ax is None:
      ax = plt.gca()
   b0 = 0
   for p,n in enumerate(nK):
      b1 = b0 + n
      ax.plot(X[b0:b1,0],X[b0:b1,1], style[p%7])
      b0 = b1
   # on impose une échelle isométrique
   ax.set_aspect("equal")
   
def visu_classes(X, classe, C, ax=None):
   """dessin des classes"""
   
   K = max(classe)+1;
   n,p = X.shape
   assert K <= 6 , "Nb de classes limité à 6 max"
   assert p == 2 , "visualisation uniquement pour dimension 2"    

   sym = ['o', 'd', 'v', '^', '*', 'p']
   col = ['b', 'g', 'r', 'm', 'y', 'c']

   if ax is None:
      ax = plt.gca()
      
   # dessin des centres
   ax.plot(C[:,0],C[:,1],'kx',markersize=15)

   # dessin des classes
   for i in range(K):
      ind_bool = classe == i
      xi = X[ind_bool,0]; yi = X[ind_bool,1]
      ax.plot(xi,yi,col[i]+sym[i],markersize=5)

   # on impose une échelle isométrique
   ax.set_aspect("equal")

def tirer_entiers_tous_distincts(n,K):
   """ retourne une liste de K entiers de [0,n-1] tous distincts """
   assert K <= n, "K doit être inférieur ou égal à n"
   m = []
   for k in range(K):
       while True:
           u = np.random.randint(0,n)
           if u not in m:
               m.append(u) ; break
   return m

def barycentrage(X, classe, K):
   """ 
   calcul du barycentre de chaque classe 
   
   X : tableau (n, p) n nb de points, p nb de caractères
   classe : tableau (n) classe[i] est la classe du point X[i,:]
   K : nb de classes

   retourne
   G : tableau (K, p) G[k,:] étant le barycentre de la classe k
   """
   n, p = np.shape(X)
   G = np.zeros((K, p))
   ne = np.zeros(K, dtype="int32")
        
   for i in range(n):
      k = classe[i]
      G[k,:] += X[i,:]
      ne[k] += 1   
   for k in range(0,K):
      if ne[k] == 0:
         return
      
      G[k] /= ne[k]
      
   return G

def affectation(X, C):
   """
   partitionne les points X en fct de leur distance aux centres C

   X : tableau (n, p) n nb de points, p nb de caractères
   C : tableau (K, p) K nb de classes

   retourne
   classe : tableau (n,) (classe[i] est la classe du point i)
   I : tableau (K,) (inertie de chaque classe par rapport aux centres C)
   """
   n, _ = np.shape(X)
   K, _ = np.shape(C)
   
   I = np.zeros(K)
   classe = np.zeros(n, dtype='int32')
   
   nbcht = 0
   for i in range (n):
      d2min = np.inf
      kmin = 0
      for k in range(K):
         temp = np.sum((X[i,:] - C[k,:])** 2)
         if temp < d2min:
            d2min = temp
            kmin = k
      if kmin != classe[i]:
         classe[i] = kmin
         nbcht += 1
      I[kmin] += d2min
   return classe, I
  

def barycentragev(X, classe, K):
   """ 
   calcul du barycentre de chaque classe (version vectorielle)
   
   X : tableau (n, p) n nb de points, p nb de caractères
   classe : tableau (n) classe[i] est la classe du point X[i,:]
   K : nb de classes

   retourne
   G : tableau (K, p) G[k,:] étant le barycentre de la classe k
   """
   n,p = X.shape
   G = np.zeros((K,p))
   for k in range(K):
      ind = np.nonzero(classe == k)[0]
      G[k,:] = np.mean(X[ind,:],axis=0)
   return G

def affectationv(X, C):
   """
   partitionne les points X en fct de leur distance aux centres C (version vectorielle)

   X : tableau (n, p) n nb de points, p nb de caractères
   C : tableau (K, p) K nb de classes

   retourne
   classe : tableau (n,) (classe[i] est la classe du point i)
   I : tableau (K,) (inertie de chaque classe par rapport aux centres C)
   """
   K,p = C.shape
   n,p = X.shape
   uns = np.ones(K)
   # initialisation en utilisant les distances vis à vis du centre de la classe 0
   d2 = np.sum((C[0,:] - X)**2,axis=1)
   classe = np.zeros(n,dtype='int32')
   for k in range(1,K):
      # calcul des distances vis à vis du centre de la classe k
      d2_new = np.sum((C[k,:] - X)**2,axis=1)
      # indices des points qui changent de classe
      ind = np.nonzero(d2_new < d2)[0]
      classe[ind] = k
      d2[ind] = d2_new[ind] # ou encore d2 = np.minimum(d2, d2_new)
      # on pourrait détruire d2_new avec un  del d2_new ?
   # calcul inertie
   I = np.zeros(K)
   for k in range(K):
      ind = np.nonzero(classe == k)[0]
      I[k] = np.sum(d2[ind])
   return classe, I

def partition_init(X, K):
   """ Partitionnement initial au hasard.
   
   Méthode : on titre uniformément K points tous distincts parmis les n 
             points (lignes) du tableau X ; ces points sont alors considérés
             comme les centres initiaux des classes (tableau C); les classes 
             initiales sont obtenues en regroupant les points les plus proche 
             des centres.

   X : tableau (n,p), X[i,:]  caractéristiques du point i 
   K : nombre de classes/groupes

   retourne :

   classe : tableau (n,) (classe[i] est la classe du point i)
   C (K,p) contenant les centres des classes
   I tableau (K,) I[k] est l'inertie de la classe k autour du centre C[k,:]
   """
   n,p = X.shape
   ind = tirer_entiers_tous_distincts(n,K)
   C = X[ind,:]
   classe, I = affectationv(X, C)
   return classe, C, I

def hmeans(X, K, info=False):
   """
   Classification par H-means

   X : tableau (n,p) 
   K : entier > 0 nombre d classes désirés
   info : booléen si vrai affiche l'inertie totale après chaque itération

   retourne :

   classe : tableau (n,) classe[i] donne le numéro de la classe du point X[i,:]
   I : tableau (K,) inertie de chaque classe autour de son centre
   C : tableau (K,p) : centre (barycentre) de chaque classe
   it : nb d'itérations pour obtenir la congergence (stabilisation complète)   
   """
   pass

def partition_qopt(X, K, nb_essais=10, info=False):
   """
   Tentative de trouver une partition qusi-optimale des points X en K classes
   c'est à dire telle que l'inertie totale soit la plus faible possible.
   Pour cela on appelle nb_essais fois l'algorithme H-means et on retient
   la partition obtenue ayant la plus faible inertie.

   X : tableau (n, p)
   K : entier positif

   retourne :
  
   classe_qopt : tableau (n,) 
   I_qopt : tableau (K,)
   C_qopt : tableau (K, p)
   """
   pass
   
def _classes_vers_points(classe):
   """
   Calcule une liste L de K éléments où L[k]
   est un tableau 1d contenant les indices des 
   points de la classe k. Les classes sont sensées
   être numérotées de 0 à K-1, ainsi K = max(classe) + 1.
   Fonction utilisée par scores_silhouette_naif.
   """
   K = max(classe) + 1
   L = [None]*K
   for k in range(K):
      L[k] = np.nonzero(classe==k)[0]
   return L
   
def scores_silhouette_naif(X, classe):
   """
   Calcule le score sihouette de chaque point de X pour 
   la classification donnée par classe.
   """
   n = X.shape[0]
   score_sil = np.zeros(n)
   L = _classes_vers_points(classe)
   K = len(L)
   for i in range(n):
      # classe du point i
      k = classe[i]
      # calcul de la distance entre X[i,:] et tous les autres points
      # (y compris lui-même ce qui donne 0)
      di = np.sqrt(np.sum((X[i,:] - X)**2,axis=1))
      # Calcul du score de i
      # 1-distance moyenne entre X[i,:] et les points de sa classe (k)
      ai = np.sum(di[L[k]])/(len(L[k]) - 1)
      # 2-calcul de la distance moyenne entre X[i,:] et la classe la plus proche
      bi = np.inf
      for kp in range(K):
         if kp != k:
            # bkp est la distance moyenne entre X[i,:] et les points de la classe kp
            bkp =  np.sum(di[L[kp]])/len(L[kp])
            if bkp < bi:
               bi = bkp
      # 3-calcul du score proprement dit
      score_sil[i] = (bi - ai)/max(ai, bi)
      
   # moyenne par classe
   score_sil_cl = np.zeros(K)
   for k in range(K):
      score_sil_cl = np.mean(score_sil[L[k]])

   # score total
   score_tot = np.mean(score_sil)

   return score_tot, score_sil, score_sil_cl

      


   
