#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[]) {

    char fichierSrc[80] = NULL, fichierDest[80] = NULL;

    printf("Fichier source : ");
    scanf("%s", &fichierSrc);
    printf("Fichier destination : ");
    scanf("%s", &fichierDest);

    copier_fichier(fichierSrc, fichierDest);

    return 0;
}

void copier_fichier(char *source, char *destination) {

    FILE *fichierSrc = fopen(source, "r");
    FILE *fichierDest = fopen(destination, "w");
    char *content = NULL;
    
    fscanf(fichierSrc, content);
    fprintf(fichierDest, content);

    fclose(fichierSrc);
    fclose(fichierDest);
    exit(EXIT_SUCCESS);
}
