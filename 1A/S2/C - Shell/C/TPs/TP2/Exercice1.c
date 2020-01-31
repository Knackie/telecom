//
// Created by Quentin Millardet on 2019-01-21.
//

#include <printf.h>

int mainExercice1(){
    char s1[] = { 'S', 'a', 'l', 'u', 't', '\0'};
    char s2[] = "Salut";
    char *s3; s3="Salut";
    char *s4="Salut";
    char s5[20];
    s5[0]= 'S';
    s5[1]= 'a';
    s5[2]= 'l';
    s5[3]= 'u';
    s5[4]= 't';
    s5[5]= '\0';
    printf("S1 : %s\n", s1);
    printf("S2 : %s\n", s2);
    printf("S3 : %s\n", s3);
    printf("S4 : %s\n", s4);
    printf("S5 : %s\n", s5);

    // Question 2

    printf("Modifions S1 ... \n");
    s1[0]='D';
    printf("Modifions S2 ... \n");
    s2[0]='E';
    /**
     * Un bug se produit lorsque l'on tente de modifier S3 ou s4 ici.
     */

    //printf("Modifions S3 ... \n");
    //s3[0]='R';
    //printf("Modifions S4 ... \n");
    //s4[0]='Y';
    printf("Modifions S5 ... \n");
    s5[0]='L';
    printf("Voyons le resultat : \n");
    printf("S1 : %s\n", s1);
    printf("S2 : %s\n", s2);
    printf("S3 : %s\n", s3);
    printf("S4 : %s\n", s4);
    printf("S5 : %s\n", s5);
    return 0;
    /**
     * On peut ainsi conclure qu'il n'est pas possible de modifier s4 ou s3 après leur affectation
     * Le type d'affectation de S3 et S4 n'est pas stockée dans le même espace mémoire que dans les autres
     */
}