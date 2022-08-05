import json
import numpy as np

from tools import computeSpectrum

# remplis le fichier "spectrums.json" en calculant les spectres des échantillons spécifiés dans ce fichier
with open('spectrums.json', 'r') as f:
    files_dict = json.load(f)

for fileName in files_dict:
    Y,Q = computeSpectrum(fileName,plot=False)
    files_dict[fileName] = {
        "spectre":Y.tolist(),
        "pitch":Q
    }

f = open('spectrums.json','w')
f.write(json.dumps(files_dict,separators=(',', ':'), sort_keys=True, indent=4))
f.close()

# remplis le fichier "averageSpectrums.json" en faisant la moyenne des spectres
# de chaque voyelle du fichier "spectrums.json"
with open('averageSpectrums.json', 'r') as f:
    vowels_dict = json.load(f)

for vowel in vowels_dict:
    # à changer la valeur en dur ? prendre la taille du premier spectre plutot
    spectrumSum = np.zeros(139)
    fileNb = 0
    for fileName in files_dict:
        fileNb = fileNb + 1
        if fileName.startswith(vowel):
            # print(np.asarray(files_dict[fileName]).size)
            spectrumSum = np.add(np.asarray(files_dict[fileName]["spectre"]),spectrumSum)
    vowels_dict[vowel] = (spectrumSum/fileNb).tolist()

f = open('averageSpectrums.json','w')
f.write(json.dumps(vowels_dict,separators=(',', ':'), sort_keys=True, indent=4))
f.close()


