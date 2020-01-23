#!/bin/bash

##Exercice 1

# Création du fichier de travail 

echo -e "\n\nExercice 1 : \n\n"

echo -e "hello world\n\nthis is a world redable test file let's start shall we?\n\nstart the world is not enough. But the world shouldw be. end\n\nstart with a better world ending with a world of hate is not an option" > largefile.txt

cat largefile.txt | sed -e "/^start,/^end/ s/world/people/g"

##Exercice 2

echo -e "\n\nExercice 2 : \n\n"

echo -e "je ne suis pas là\n 0\n je ne suis pas la encore\n a\n Je mange là" | sed -e "/^\ [0-9]/ s/\ /0/g"

