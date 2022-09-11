# -*- coding: utf-8 -*-

"""module d'utilitaires pour le TP 1 de GRO comprenant les fonctions
   linprog, affiche_resultat et print_key

   Ecrit par Bruno Pinçon pour le TP 1 de GRO  

"""

from pymprog import *
import numpy as np
import matplotlib.pyplot as plt


def linprog(c, ineq= None, eq= None, sens="min", lb = None, ub = None, typevar = float, verb = 0) :
    """
    Une fonction linprog (un peu comme celle de Matlab) pour résoudre des PL en python
    et qui utilise le module pymathprog (qui lui est une vraie interface python sur le 
    solveur glpk).


    Utilisation :

       stat, F, X = linprog( c, ineq=(A,b), eq=(Ae,be), sens="min"|"max",
                             lb= , ub=, typevar=float|int|bool, verb=0|1|2|3)

       tous les arguments sont des arguments optionnels nommés sauf le premier.

       c : il définit la fct coût (f(x) = c^T x)  
           c doit être un numarray 1-d. Le nbre d'éléments de c est appelé n

       ineq : il définit les contraintes d'inégalités ; ineq s'il est
              fourni doit être un tuple à 2 éléments (A,b) définissant une matrice
              A et un vecteur b, les contraintes étant :

                               A x <= b

              A doit être un numarray 2-d avec m lignes et n colonnes
              b doit être un numarray 1-d avec m éléments


       eq : il définit les contraintes d'égalités ; eq s'il est
            fourni doit être un tuple à 2 éléments (Ae,be) définissant une matrice
            Ae et un vecteur be, les contraintes étant :

                               Ae x = be

            Ae doit être un numarray 2-d avec me lignes et n colonnes
            be doit être un numarray 1-d avec me éléments

       sens : sens="min" pour minimiser (défaut) et sens="max" pour maximiser

       lb : s'il est fourni, lb doit être un numarray 1-d avec n éléments définissant les
            bornes inf. S'il n'est pas fourni, on a lb = zeros(n)

       ub : s'il est fourni, ub doit être un numarray 1-d avec n éléments définissant les
            bornes sup. S'il n'est pas fourni, on a ub = inf*ones(n)

       Le domaine sur lequel on optimise f est donc défini par :

         lb[k] \le x[k] \le ub[k]  pour k de 0 à n-1
         A x <= b
         Ae x = be


       typevar : float (pour des variables continues, i.e. réelles), int (pour des variables
                 entières) et bool (pour des variables binaires {0,1})

       verb : entier de 0 (pas de messages) à 3 (messages max) niveau de bavardage du solveur
              défaut 0.

      En sortie :

         stat : = 5 si le solveur a trouvé la (ou une) solution optimale
                = 6 si la fonction est non bornée sur le domaine
                = 4 si le domaine est l'ensemble vide (on dit que le PL est "infeasible")
                = 1 idem à 4 (ce statut est obtenu lorsque typevar = int ou bool et que le PL 
                              "relaxé" (i.e. sans les contraintes d'intégrité) est "infeasible")

         F : valeur de la fonction à l'optimum (+-Inf si non borné , None dans les autres cas)

         X : valeurs des variables à l'optimum (None si stat est différent de 5)

       Attention : cette fonction n'a pas été trop testée...

       A faire : introduire les options du solveur intopt...

    """
    # parse positionnal arg 1
    if  not (type(c) == np.ndarray  and  c.ndim == 1) :
        raise Exception("arg 1 doit être un ndarray à une dimension")
    else:
        n = c.shape[0]

    # parse optionnal arg ineq
    if ineq is not None :
        if not (type(ineq) == tuple and len(ineq) == 2) :
            raise Exception("arg optionnel ineq doit être un tuple à 2 éléments")
        else :
            A = ineq[0];
            if not (type(A) == np.ndarray and A.ndim == 2 and A.shape[1] == n) :
                raise Exception("ineq[0] doit être un ndarray à 2 dimensions et avec "+format(n)+" colonnes")
            m = A.shape[0]   # nb de contraites d'inégalités

            b = ineq[1];
            if not ( type(b) == np.ndarray  and  b.ndim == 1 and  b.shape[0] == m) :
                raise Exception("ineq[1] doit être un ndarray à 1 dimension avec "+format(m)+" éléments")

    # parse optionnal arg eq
    if eq is not None :
        if not (type(eq) == tuple and len(eq) == 2) :
            raise Exception("arg optionnel eq doit être un tuple à 2 éléments")
        else :
            Ae = eq[0];
            if not ( type(Ae) == np.ndarray  and  Ae.ndim == 2  and  Ae.shape[1] == n) :
                raise Exception("eq[0] doit être un ndarray à 2 dimensions et avec "+format(n)+" colonnes")
            me = Ae.shape[0]   # nb de contraites d'égalités

            be = eq[1];
            if not ( type(be) == np.ndarray  and  be.ndim == 1  and  be.shape[0] == me) :
                raise Exception("eq[1] doit être un ndarray à 1 dimension avec "+format(me)+" éléments")

    # parse optionnal arg lb
    if lb is None :    # borne inf par défaut 0
        lb = np.zeros(n)
    else :
        if not ( type(lb) == np.ndarray  and  lb.ndim == 1  and  lb.shape[0] == n ) :
            raise Exception("arg optionnel lb doit être un ndarray à 1 dimension avec "+format(n)+" éléments")

    # parse optionnal arg ub
    if ub is None :    # borne sup par défaut +inf (mais si une variable est binaire sa borne sup sera 1)
        ub = np.inf*np.ones(n)
    else :
        if not ( type(ub) == np.ndarray  and  ub.ndim == 1  and  ub.shape[0] == n ) :
            raise Exception("arg optionnel ub doit être un ndarray à 1 dimension avec "+format(n)+" éléments")


    # verify that lb <= ub
    for k in range(n):
        if not lb[k] <= ub[k] :
             raise Exception("erreur lb["+format(k)+"] n'est pas <= à ub["+format(k)+"]")

    # parse optionnal arg sense
    if not ( type(sens) == str  and  sens in ["min", "max"] ) :
        raise Exception("arg optionnel sens doit être égal à 'min' ou 'max'")

    # parse optionnal arg typevar
    if not ( type(typevar) == type  and  typevar in [float, int, bool] ) :
        raise Exception("erreur arg optionnel typevar doit être : float, int ou bool")

    # parse optionnal arg verb
    if not ( type(verb) == int and verb in [0,1,2,3] ) :
        raise Exception("erreur arg optionnel verb doit être : 0, 1, 2 ou 3")

    # on déclare le modèle avec les fonctions de pymprog
    begin('basic')

    # les variables
    x = var('x', n, kind=typevar)
    if typevar != bool :
        for i in range(n) :
            lb[i] <= x[i] <= ub[i]

    # la fct coût
    if sens == "max":
        maximize(sum(c[i]*x[i] for i in range(n)))
    else:
        minimize(sum(c[i]*x[i] for i in range(n)))

    # les constraintes d'inégalité
    if ineq is not None :
        for i in range(m):
            sum( A[i,j]*x[j] for j in range(n)) <= b[i]

    # les constraintes d'égalité
    if eq is not None :
        for i in range(me):
            sum( Ae[i,j]*x[j] for j in range(n)) == be[i]

    # on choisit le solveur pour chaque type de probleme (float => simplexe, int ou bool => intopt)
    # (j'ai exclu interior et exact qui pourraient être utilisés danns le cas float (variables continues))
    # On règle aussi le niveau de bavardage (sorties du solveur glpk) ...
    if typevar == float :
        solver('simplex', msg_lev = verb)
    else :
        solver('simplex', msg_lev = verb) # oui le solveur intopt peut utiliser le simplexe, on impose donc
                                          # le niveau de verbosité aussi pour ce dernier...
        solver('intopt', msg_lev = verb)
    
    # résolution...
    solve()

    # status du calcul
    stat = status()

    if stat == 5 :   # l'optimum a été trouvé
        X = np.zeros(n)
        for i in range(n):
            X[i] = x[i].primal
        F = vobj()

    elif stat == 6 :   # fct coût non bornée
        X = None
        if sens == "max" :
            F = np.inf
        else :
            F = -np.inf

    elif stat == 4 :   # domaine vide
        X = None
        F = None

    elif stat == 1 :   # pour un pb int ou bool cette valeur s'obtient lorsque
                       # le pb relaxé (sans les contraintes d'intégrité)  n'a pas de solution réalisable
        X = None
        F = None

    else :
        print("Attention : valeur de status =("+format(stat)+") non prise en compte actuellement !")
        X = None
        F = None

    end()

    return stat, F, X

    
def affiche_resultat(stat, F, X) :
    """petit utilitaire pour afficher les résultats de linprog"""
    
    if stat == 5 :
        print("Le solveur a trouvé une solution optimale.")
        print("   F(x*) = "+format(F));
        for k in range(len(X)) :
            print("   x*["+format(k)+"] = "+format(X[k]))
    elif stat == 6 :
        print("La fonction coût n'est pas majorée ou minorée sur le domaine.")
        print("F = "+format(F));
        
    elif stat in [4, 1] :
        print("Le domaine est vide (le PL est dit 'unfeasible').")
    else :
        print("Statut du solveur non prise en compte par linprog...")
    
        

def print_key(S, t, x, n, m):
    """permet d'afficher la répartition des fichiers sur les clés usb dans
       l'exercice 3 du TP 1
    S : taille des clefs usb
    t : tableau (numaray 1-d) contenant la taille de chaque fichier
    x : solution obtenue par le solveur (non reformattée) (tableau numarray 1-d
        de taille m(n+1))
    n : nb de fichiers
    m : nb initial de clefs """

    # qq vérifications...
    if  not (type(x) == np.ndarray  and  x.ndim == 1 and x.shape[0] == m*(n+1)) :
        raise Exception("le troisième argument n'est pas conforme")
    if not (len(t) == n) :
        raise Exception("le deuxième argument n'est pas conforme")
    
     
    couleurs = ["lightgreen", "tan",  "lightgrey", "orange", "skyblue", "hotpink",
                "salmon", "aqua", "powderblue", "turquoise", "gold", "lightpink"]

    nc = len(couleurs)
    
    X = x[0:n*m]
    X = np.reshape(X,(n,m),order='F')
    y = x[n*m:]
    cles_fichiers = []
    for j in range(m):
        if y[j] :
            L = [j]
            for i in range(n):
                if X[i,j] :
                    L.append(i)
            cles_fichiers.append(L)
    # nb de clés à dessiner
    nb_key = len(cles_fichiers)

    # affichage
    plt.clf()
    ax = plt.axes()
    # marges (gauche et droite)
    delta = S*0.05
    yticks_lab = []
    ax.set(xlim=(-delta, S+delta), ylim=(0.5, nb_key+0.5))
    for k in range(nb_key) :
        ybas = 1+k-0.25; yhaut = ybas + 0.5; x0 = 0
        num_cle = cles_fichiers[k][0]
        yticks_lab.append("clé "+format(num_cle))
        nb_fich = len(cles_fichiers[k]) - 1
        for j in range(nb_fich) :
            num_fich = cles_fichiers[k][j+1]
            x1 = x0 + t[num_fich]
            ax.fill([x0,x1,x1,x0,x0],[ybas,ybas,yhaut,yhaut,ybas],couleurs[num_fich % nc])
            plt.plot([x1, x1],[ybas, yhaut],"k")
            plt.text(0.5*(x0+x1),0.5*(ybas+yhaut),format(num_fich),
                    horizontalalignment='center',verticalalignment='center')
            #
            x0 = x1
        plt.plot([0,S,S,0,0],[ybas,ybas,yhaut,yhaut,ybas],"k")
        ax.set_yticks(np.arange(1,nb_key+1))
        ax.set_yticklabels( yticks_lab)
        ax.set_xticks([0,S])
        plt.title("Répartition des fichiers sur les clés",fontsize=18)
    plt.show()
    return None

    
    
                
           
           
        
        
   
           

    


    
        
        
