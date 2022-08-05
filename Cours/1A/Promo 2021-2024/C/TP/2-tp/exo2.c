#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char min2maj(char c) {

    if( c >= 'a' && c <= 'Z')
        return c-('a'-'A'); // enlève offset pour passer en maj
    else
        return c;
}


char maj2min(char c) {

    if( c >= 'A' && c <= 'Z')
        return c+('a'-'A'); // ajoute offset pour passer en maj
    else
        return c;
}

int main(int argc, char const *argv[]) {
    
    char mot[30];
    char mot2[30];
    char c;
    int i;
    printf("Entrer un mot : ");
    scanf("%s", mot);

    i=0;
    while(mot[i] !='\0') {
        c = mot[i];

        // si lettre min
        if (c>= 'a' && c<= 'z')
            mot2[i] = min2maj(c);

        // si lettre maj
        else if (c>='A' && c<= 'Z')
            mot2[i] = maj2min(c);

        // si ce n'est pas une lettre
        else mot2[i] = mot[i];

        i++;
    }

    return 0;
}
