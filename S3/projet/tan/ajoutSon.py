import json

from numpy import transpose
from tools import computeSpectrum, computeTab
import matplotlib.pyplot as plt
import operator
import sounddevice as sd
import json
import random
from scipy.io.wavfile import write



voyelle = input("\nQuelle voyelle va être ajoutée ? Taper votre réponse ici : \n")
print (voyelle)
fs = 22050  # Sample rate
seconds = 0.5  # Duration of recording
input("Press Enter to record...")
myrecording = sd.rec(int(seconds * fs), samplerate=fs, channels=1)
sd.wait()  # Wait until recording is finished

Hm,Qm = computeTab(transpose(myrecording)[0][3000:5048],fs)

plt.plot(Hm)

plt.xlabel('x label')
plt.ylabel('y label')

plt.title("signal entrant")
plt.show()

input("Press Enter to accept song...")
fileName = voyelle.upper()+'/'+voyelle.lower()+'_'+str(random.randint(0,10000000000000))+'.wav'
with open('spectrums.json', 'r') as f:
    files_dict = json.load(f)
    files_dict[fileName] = {
        "spectre": Hm.tolist(),
        "pitch": Qm
    }
    f = open('spectrums.json', 'w')
    f.write(json.dumps(files_dict, separators=(',', ':'), sort_keys=True, indent=4))
    f.close()
write('sounds/'+fileName, fs, myrecording)  # Save as WAV file

