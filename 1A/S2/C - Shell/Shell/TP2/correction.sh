ce 1

#!/bin/sh

repertoire=$1
set `ls $repertoire`
echo $#
echo $*
while test $# -gt 1
    do
    for fich in $*
    do
        echo $fich
        if
            test $1 != $fich
        then
            if cmp -s $repertoire/$fich $repertoire/$1
                then
                    echo $fich sera effacé
                    # rm -i $repertoire/$fich
            fi
        fi
    done
shift
done

Exercice 3

#!/bin/sh

find $HOME  -name 'core' -o -name '*~' -o -name '#*#' -exec ls -l {} \;

exit 0

Exercice 4

1. grep oscilloscope test_grep.txt

2. grep -n "L'oscilloscope" test_grep.txt

3. grep theta$ test_grep.txt

4. grep "x [0-9]" test_grep.txt 

ou 

"x [0-9][0-9]*

5. grep "\- Régler" test_grep.txt 

ou grep -e "- Régler" test_grep.txt

6. grep -i "méthode" test_grep.txt

7. grep "f(.*)" test_grep.txt

8. egrep "une +trace" test_grep.txt

9. grep "[0-9]\{5\}" test_grep.txt

10.  grep "[0-9].*[0-9].*[0-9].*[0-9].*[0-9]" test_grep.txt

11. egrep "omega|phi" test_grep.txt

12. grep "alpha.*beta" test_grep.txt

13. grep "delta" test_grep.txt | grep "gamma"

14. egrep -w " [0-9]{12}" test_grep.txt

15. grep "\(ellipse.*\)\{2\} | grep -v "\(ellipse.*\)\{3\} test_grep.txt
