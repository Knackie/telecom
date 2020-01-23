#!/bin/bash

fichier_liste="C_FILE/c_liste"
mkdir -p C_FILE
echo -e "Fichier en *.c : \n" > ${fichier_liste}
ls -1 *.c >> ${fichier_liste};
echo -e "Fichier en *.o : \n" >> ${fichier_liste}
ls -1 *.o >> ${fichier_liste};
cp $(tail -n 1 ${fichier_liste}) C_FILE
cat ${fichier_liste}