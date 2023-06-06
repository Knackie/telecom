#!/bin/bash

#Ecrire une commande de lecture permettant de boucler sur une lecture au clavier jusqu'a l'obetention de la chaine "oui" ou "non"

lect=""
echo -e "Veuillez saisir \"oui\" ou \"non\" : " 
read lect
while [[ "$lect" != "oui" ]] && [[ "$lect" != "non" ]]
do 
	echo -e "Veuillez saisir \"oui\" ou \"non\" : "
	read lect
done 
