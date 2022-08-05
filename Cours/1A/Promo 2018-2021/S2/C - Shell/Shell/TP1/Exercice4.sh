#!/usr/bin/env bash

if [[ $# -le 1 ]]
then
    echo "Usage : $0 suffixe [Fichier_à_appliquer [ Fichier_à_appliquer [ ... ]]]";
    exit 0;
else
    nomfichier=$(echo $2 | cut -d. -f1);
    if [[ $1 == '-' ]]
    then
        dest="${nomfichier}"
    else
        dest="${nomfichier}.$1"
    fi
    mv $2 ${dest}
fi