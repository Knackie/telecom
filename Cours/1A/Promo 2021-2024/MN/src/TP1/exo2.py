from socket import MsgFlag
import numpy as np
import sys

def giveMAndMs(b : int, p : int, e_max : int):
    M = 0
    Ms = 0
    
    M = b**(e_max+1)-b**(e_max+1-p)
    Ms = (M+b**(e_max+1))//2
    
    return M, Ms


if __name__ == "__main__":
    M, Ms = giveMAndMs(2, 53, 1023)
    Msys = sys.float_info.max
    print("Msys (int) =")
    print(int(Msys))
    print("M =")
    print(M)
    print("Ms =")
    print(Ms)
    
    # ERREUR
    #print("Ms (double) =") 
    #print(float(Ms))
    
    print("Ms-1 (double) =")
    print(float(Ms-1))
    print("Msys =")
    print(Msys)
    print("fl(Ms-1) = M ? : ")
    print(float(Ms-1)==Msys)