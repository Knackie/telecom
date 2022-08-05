#include <stdlib.h>
#include <stdio.h>

void afficherLigne(int nbColonnes, char *val1, char *val2);

int main(int argc, char const *argv[]) {

    int nbLignes = atoi(argv[1]);
    int nbColonnes = atoi(argv[2]);
    char *motif[] = { argv[3] , argv[4] };

    for(int i=0; i < nbLignes; i++) {
        if(i % 2 == 0) {
            afficherLigne(nbColonnes, motif[0], motif[1]);
        } else {
            afficherLigne(nbColonnes, motif[1], motif[0]);
        }
    }
    
    return 0;
}

void afficherLigne(int nbColonnes, char *val1, char *val2) {

    int j;

    for (j=0; j < nbColonnes; j = j+2) {
        printf("%s%s ", val1, val2);
    }
    
    if(j != nbColonnes)
        printf("%s\n", val1);
    else
        printf("\n");
}