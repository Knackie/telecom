#include <stdlib.h>
#include <string.h>
#include <stdio.h>

char *sujet[] = {"le cadavre", "le chat", "le chien", "la grenouille"};
char *adjectif1[] = {"exquis", "noir", "pouilleux", "gluant"};
char *verbe[] = {"boira", "mange","aime","capture"};
char *complement[] = {"le vin", "un rat", "un os","un moustique"};
char *adjectif2[] = {"nouveau","gris","moelleux","agressif"};

char mot1[] = {"Bonjour"};
char *mot2[0]={"bonjour2"};

int main(int argc, char const *argv[])
{

    srand (time(NULL));
    // pour générer des indices aléatoires
    int nb0 = rand() %4;
    int nb1 = rand() %4;
    int nb2 = rand() %4;
    int nb3 = rand() %4;
    int nb4 = rand() %4;

    printf("nb0 - %d nb1 - %d nb2 - %d nb3 - %d nb4 - %d", nb0, nb1, nb2, nb3, nb4);

    printf("mot1 = %s\n", mot1);
    printf("mot2 = %s\n", mot2[0]);


    printf("%s %s %s %s %s \n", sujet[nb0], adjectif1[nb1], verbe[nb2], complement[nb3], adjectif2[nb4]);

    return 0;
}