#include <stdlib.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char const *argv[]) {

    // Exercice 1
    for (int i=0; i < argc; i++) {
        printf("L'argument no %d contient %d caractere(s)\n", i, strlen(argv[i]));
    }

    return 0;
}

