#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int first_occurrence(char c, char* mot) {
    int i = 0;
    int place = 0;
    while( mot[i] != '\0' ) {
        if( mot[i++] == c) {
            place = i;
            return place;
        }   
    }
}

int last_occurence(char c, char* mot) {
    int i = 0;
    int place = 0;
    while (mot[i] != '\0') {
        if (mot[i++] == c) {
            place = i;
        }
    }
    return (place);
}

int main(int argc, char const *argv[]) {
    /* code */
     char mot[30];
    int result;
    char c;

    printf("Entrer le caractere : ");
    scanf("%c", &c);
    
    printf("Taper une suite de mot en terminant par 'exit' \n");

    scanf("%s", mot);

    while(strcmp(mot, "exit")) {
        printf("%s\t %d %d\n", mot, first_occurrence(c, mot), last_occurence(c, mot));
        scanf("%s", mot);
    }

    printf("Fin du programme\n");

    return 0;
}
