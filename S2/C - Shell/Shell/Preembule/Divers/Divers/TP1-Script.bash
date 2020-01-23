#!/bin/bash

#Ecrire un fichier de commande de nom " rnageTP1.sh" qui déplace tous les fihcier terminées par " .c" du répertoire TP1 dans le répertoire TP1/Sources (à créer) et tous les autres dans le repertoire TP1/Divers (à créer également) et affiche le contenu de ces deux repertoires. On suppose que rangeTP1.sh se trouve dans le même repertoire que les fichiers " .c" et les autres fichiers.

emp="."

if [ $? -gt 0 ]
then 
	$emp=$1		
fi
Sources=$emp/Sources
Divers=$emp/Divers
mkdir -p $Sources
mkdir -p $Divers

for element in "$(ls)"
do	
	longueurChaine=${#element}
	if [ "${element:$longueurChaine-2:2}" == '.c' ]
	then
		mv $element $Sources
	else
		mv $element $Divers
	fi
done
