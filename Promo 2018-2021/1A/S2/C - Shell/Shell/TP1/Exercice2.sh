#!/usr/bin/env bash

i=1;
recherche=$(echo $PATH | cut -d: -f${i})
while [[ $recherche != "" ]]
do
    find $recherche -name "$1" 2>/dev/null;
    recherche=$(echo $PATH | cut -d: -f${i})
    i=$((i+1));
done


