#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>


int main(int argc, char const *argv[]) {

    FILE *file_src, *file_dest;

    char source[80], c;
    char destination[80];

    // Recupération du nom du fichier source et destination
    if (argc < 3) {
        printf("Entrer le nom du fichier source : \n");
        scanf("%s", source);
        printf("Entrer le nom du fichier de destination : \n");
        scanf("%s", destination);
    } else {
        strcpy(source, argv[1]);
        strcpy(destination, argv[2]);
    }

    printf("SOURCE = %s \n", source);
    printf("DESTINATION = %s \n", destination);

    // Copie du fichier source vers destination
    file_src = fopen(source, "r");

    if (file_src == NULL) {
        perror("Probleme durant l'ouverture du fichier source \n");
        exit(1);
    }

    file_dest = fopen(destination, "w");

    if (file_dest == NULL) {
        perror("Probleme durant l'ouverture du fichier destination \n");
        exit(1);
    }

    while(fscanf(file_src, "%c", &c) != EOF) {

        fprintf(file_dest, "%c", c);
    }

    fclose(file_src);
    fclose(file_dest);

    return 0;
}
