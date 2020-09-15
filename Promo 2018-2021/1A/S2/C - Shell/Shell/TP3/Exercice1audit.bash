#!/usr/bin/env bash


for fichier in $(find . -type f)
do
    l=$(ls $fichier)
    if [[ $(echo $l | cut -d' ' -f1| grep "^$") != "null" ]]
    then
        echo $fichier
    fi
done
