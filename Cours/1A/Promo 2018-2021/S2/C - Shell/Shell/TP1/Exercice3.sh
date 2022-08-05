#!/usr/bin/env bash

if [[ $# -le 1 ]]
then
    echo "Usage : $0 suffixe Fichier_à_appliquer";
    exit 0;
else
    i=0
     for element in $*
     do
     if [[ i -eq 0 ]]
     then
        i=1

      else
        mv $element "$element.$1" 2> /dev/null
        if [[ $? -ne 0 ]]
        then
        echo -e "$0 : $element inexistant"
        fi
       fi
    done
fi