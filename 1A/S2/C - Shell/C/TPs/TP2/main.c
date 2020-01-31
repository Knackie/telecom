#include <stdio.h>
#include <string.h>
#include "Exercice1.h"
#include "Exercice2.h"
#include "Exercice3.h"
#include "Exercice4.h"

int main() {
    int num = 6;
    char entree;
    switch (num){
        case 0 :
            mainExercice1();
            break;
        case 1 :
            entree = 'a';
            printf("On entre le caractère %c et on obtient le caractère %c",entree,min2maj(entree));
            break;
        case 2 :
            entree = 'B';
            printf("On entre le caractère %c et on obtient le caractère %c",entree,maj2min(entree));
            break;
        case 3 :
            printf("La chaine resultat est : %s",inverseurCaractereMinMaj());
            break;
        case 4 :
            printf("");
            int entier;
            char str[] = "JeSuisLa";
            char caractere = 'a';
            entier = first_occurrence(str, caractere);
            printf("Le premier caractère \"%c\" a été trouvé à la place %i", caractere, entier);
            break;
        case 5 :
            printf("");
            int entier_last;
            char str_last[] = "JeSuisLa";
            char caractere_last = 'a';
            entier_last = last_occurrence(str_last, caractere_last);
            printf("Le premier caractère \"%c\" a été trouvé à la place %i", caractere_last, entier_last);
            break;
        case 6 :
            printf("Saisissez votre mot : ");
            char chaine_recupere[1000];
            char caractere_recupere;
            scanf("%s", chaine_recupere);
            getchar();
            printf("Votre caractère maintenant : ");
            scanf(" %c", &caractere_recupere);
            printf("La première occurence de votre caractère est à l'emplacement %i\n", first_occurrence(chaine_recupere, caractere_recupere));
            printf("La dernière occurence de votre caractère est à l'emplacement %i\n", last_occurrence(chaine_recupere, caractere_recupere));
            break;
        case 7 : {
            char chaine_recupere_while[10000];
            char caractere_recupere_while;
            printf("Saisissez votre mot : ");
            scanf("%s", chaine_recupere_while);
            while (strcasecmp(chaine_recupere_while,"exit")!=0) {
                    getchar();
                    printf("Votre caractère maintenant : ");
                    scanf(" %c", &caractere_recupere_while);
                    printf("La première occurence de votre caractère est à l'emplacement %i\n",
                           first_occurrence(chaine_recupere_while, caractere_recupere_while));
                    printf("La dernière occurence de votre caractère est à l'emplacement %i\n",
                           last_occurrence(chaine_recupere_while, caractere_recupere_while));
                printf("Saisissez votre mot : ");
                scanf("%s", chaine_recupere_while);
            }
            break;
        }
        case 8 :
            printf("La chaine : %s", cadavreExquis());
            break;
        default:
            printf("Je ne fait rien");
            break;
    }
}