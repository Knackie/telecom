import json

from numpy import transpose
from tools import computeSpectrum, computeTab
import matplotlib.pyplot as plt
import operator
import sounddevice as sd

fs = 22050  # Sample rate
seconds = 0.1  # Duration of recording
input("Press Enter to record...")
myrecording = sd.rec(int(seconds * fs), samplerate=fs, channels=1)
sd.wait()  # Wait until recording is finished

Hm,Qm = computeTab(transpose(myrecording)[0],fs)

with open('spectrums.json', 'r') as f:
    files_dict = json.load(f)

spectres_dict = {
    "A": [],
    "E": [],
    "I": [],
    "O": [],
    "U": []
}
coef_correl = {}
for fileName in files_dict:
    voyelle = fileName.split('/')[0]
    H = files_dict[fileName]["spectre"]
    coef_correl[fileName]= -1
    if len(H)>0 :
        spectres_dict[voyelle].append(files_dict[fileName]["spectre"])
        Q = files_dict[fileName]["pitch"]
        coef_correl[fileName] = 0
        for k in range(0,len(H)):
            coef_correl[fileName] += H[k]*Hm[k]
        coef_correl[fileName]/=len(H)
        #coef_correl[fileName]*= min(Q,Qm)/max(Q,Qm)

plt.figure(figsize=(12, 8))
plt.plot(transpose(spectres_dict["A"]))

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("a")
plt.show()

plt.plot(transpose(spectres_dict["E"]))

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("e")
plt.show()

plt.plot(transpose(spectres_dict["I"]))

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("i")
plt.show()

plt.plot(transpose(spectres_dict["O"]))

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("o")
plt.show()

plt.plot(transpose(spectres_dict["U"]))

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("u")
plt.show()

plt.plot(Hm)

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("signal entrant")
plt.show()

plt.plot( files_dict[max(coef_correl.items(), key=operator.itemgetter(1))[0]]["spectre"])

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("signal reconnu")
plt.show()
print("\n")
print("******************************************************************************************************************")
print("******************************************************************************************************************")
print("******************************************************************************************************************")
print("\nLe son est semblable au son : ", max(coef_correl.items(), key=operator.itemgetter(1))[0])
coef_correl_par_voyelle={
    "A": [],
    "E": [],
    "I": [],
    "O": [],
    "U": []
}
for fileName in coef_correl:
    voyelle = fileName.split('/')[0]
    coef_correl_par_voyelle[voyelle].append(coef_correl[fileName])

for voyelle in coef_correl_par_voyelle:
    tmp=0
    cmpt=0
    for coef in coef_correl_par_voyelle[voyelle]:
        tmp+=coef
        cmpt+=1
    coef_correl_par_voyelle[voyelle]=tmp/cmpt
print("\nLa voyelle prononcée est : ", max(coef_correl_par_voyelle.items(), key=operator.itemgetter(1))[0], "\n")
print("******************************************************************************************************************")
print("******************************************************************************************************************")
print("******************************************************************************************************************")


