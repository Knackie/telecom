#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    char s1[] = {'S', 'a', 'l', 'u', 't', '\0'}; // Alloue 6 bytes et associe l'adresse du 1er byte à s1
    char s2[] = "Salut"; // même si "Salut" est une "string litteral", 
                        // s2 n'est pas pour autant une constante c'est une commodité d'écritude équivalente à s1
                        // '/0' est automatiquement ajouté par le compilateur à la fin
    char *s3;
    s3 = "Salut";
    char *s4 = "Salut";
    char s5[20];

    // s5 = "Salut" faux, nom tableau s5 est un pointeur cst (1er élément tab), on ne peut donc pas modifier l'adresse de s5
    // -> assignation de string INVALIDE pour les tab
    strcpy(s5, "Salut"); // autre possibilité

    // Les String (tab de char) peuvent être modifiées en utilisant s5[i]='c';

    printf("S1 = %s\n", s1);
    printf("S2 = %s\n", s2);
    printf("S3 = %s\n", s3);
    printf("S4 = %s\n", s4);
    printf("S5 = %s\n", s5);

    s1[0] = 'C';
    *s2 = 'C';
    *s5 = 'C';
    s4 = s1;
    s3 = &s1[0];

    printf("S1 = %s\n", s1);
    printf("S2 = %s\n", s2);
    printf("S3 = %s\n", s3);
    printf("S4 = %s\n", s4);
    printf("S5 = %s\n", s5);

    return 0;
}
