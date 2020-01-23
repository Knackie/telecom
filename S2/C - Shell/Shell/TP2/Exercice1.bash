#!/usr/bin/env bash

emplacement='.';
if [[ $1 != "" ]]
then
    emplacement=$1;
fi
for fichier in $(ls -1)
do
    cat $fichier >/dev/null 2>&1
    if [[ $? -eq 0 ]]
    then
        for fichierbis in $(ls -1)
        do
            if [[ "$fichier" != "$fichierbis" ]]
            then
                cmp $fichier $fichierbis 2>&1 >/dev/null
                if [[ $? -eq 0 ]]
                then
                    rm -f $fichierbis
                 fi
            fi
        done
     fi
done