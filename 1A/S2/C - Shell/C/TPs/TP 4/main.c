#include <stdio.h>
#include <string.h>

#include "Exercice2.h"

int main(int argc, char *argv[]) {
    int num = 2;
    switch (num){
        case 0 : {
            for(int i = 0; i<argc;i++){
                printf("l’argument n°%i contient %i caractere(s)\n", i, (int) strlen(argv[i]));
            }
            break;
        }
        case 1 : {
            char src[255];
            char dest[255];
            printf("Chemin du dossier source : ");
            scanf(" %s", src);
            getchar();
            printf("Chemin du dossier destination : ");
            scanf(" %s", dest);
            copieFichiers(src, dest);
        }
        case
        default:break;
    }

    return 0;
}