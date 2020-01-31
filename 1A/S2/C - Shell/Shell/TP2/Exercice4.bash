#!/usr/bin/env bash

nb=7
if [[ "$1" != "" ]]
then
    nb=$1
fi
case $nb in
    1) grep 'oscilloscope' test_grep.txt;;
    2) grep "L'oscilloscope" test_grep.txt;;
    3) grep -e "theta$" test_grep.txt;;
    4) grep -e "x [0-9]" test_grep.txt;;
    5) grep -e "- Régler" test_grep.txt;;
    6) grep -e "[Mm][Eé][Tt][Hh][oO][Dd][Ee]" test_grep.txt;; ## grep -i "méthode" test_grep.txt
    7) grep -e "f(.*)" test_grep.txt;;
    8) grep -E "une[ ]+trace" test_grep.txt;;
    9) grep -e "[0-9][0-9][0-9][0-9][0-9]" test_grep.txt;;
    10) grep -E "[0-9].*[0-9].*[0-9].*[0-9].*[0-9]" test_grep.txt;;
    11) egrep "omega|phi" test_grep.txt;;
    12) egrep "alpha.*beta" test_grep.txt;;
    13) egrep "delta" test_grep.txt | egrep "gamma";;
    14) egrep -w "[0-9]{12}" test_grep.txt;;
    15) egrep -w "ellipse{2}" test_grep.txt;;
    *) echo "Inexistant";;
esac;