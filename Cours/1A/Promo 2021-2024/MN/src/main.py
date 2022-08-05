import numpy as np

T = np.array([1, 5, 8])
print(T.dtype)

T = np.array([1, 5, 8, np.pi], dtype='int8')
print(T.dtype)

T = np.array([[1, 5, 8],[2.0, -1, 9]])
print(T)

T = np.zeros(4) #tableau 1d à 4 éléments
print(T.dtype)

U = np.zeros((4,3), dtype='int') #tableau 2d (4,3)
print(U.dtype)

B = np.ones(6, dtype='bool')
print(B)

x = np.linspace(0, 1, 5)
print(x)

x = np.logspace(-3, 3, 7)
print(x)

T = np.empty((2,2,2)) #tableau 3d à 8 éléments
print(T.ndim)
print(T.dtype)

T = np.empty((2,2), dtype='int64')
print(T.dtype)
print(T)

x = np.arange(1,13)
print(x)

y = np.reshape(x, (3,4))
print(y)

y[1,2]=72
print(x)

x = np.arange(1, 13)
y = np.reshape(x.copy(), (3,4))
y[1, 2] = 72
print(x)

# Utiliser la syntaxe t[i,j] et pas t[i][j]
# Pour référencer toute la ligne i T[i:]
# Pour référencer toute la colonne j T[:,j]
# T[::2,1::2] toutes les lignes paires + toutes les colonnes impaires

print(np.exp)