import numpy as np
import random 

def tirer_entiers_tous_distincts_prof(K,n):
    list = []
    m = 0
    for k in range(K):
        while(True):
            m = random.randint(0,n)
            if(m not in list):
                break
        list[k] = m
    return list

def tirer_entiers_tous_distincts(K,n):
    """
    Retourne une liste avec les barycentrea

        Parameters:
            K (int): nombre de barycentre
            n (int): nombre d'individus

        Returns:
            list (list): Liste des barycentre
    """
    list = []
    for k in range(K):
        while(len(list)<=k):
            m = random.randint(0,n)
            if(m not in list):
                list.append(m)
    return list


if __name__ == '__main__':
    print(tirer_entiers_tous_distincts(12, 1000))