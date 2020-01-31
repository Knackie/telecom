import numpy as np
import matplotlib.pyplot as plt
import sys
import math

n=2000;
x=np.logspace(-20,-1,n);

y1= np.sqrt(x+1) - np.sqrt(1-x);
y2=(2*x)/(np.sqrt(x+1)+np.sqrt(1-x));

ea=abs(y1-y2);
er=ea/abs(y2);
ert=(sys.float_info.epsilon)/abs(x);
plt.loglog(x[ea>0],er[ea>0]);
plt.loglog(x,ert);
print(ea);
plt.show()