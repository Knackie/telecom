//
// Created by Quentin Millardet on 2019-01-21.
//

#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <printf.h>

char* cadavreExquis(){
    char sujet[4][30] = {"Le cadavre", "Le chat", "Le chien", "La grenouille"};
    char adjectif[4][30] = {"exquis", "noir", "pouilleux", "gluante"};
    char verbe[4][30] = {"boira", "mange", "aime", "capture"};
    char complement[4][30] = {"le vin", "un rat", "un os", "un moustique"};
    char adjectif2[4][30] = { "nouveau", "gris", "moelleux", "agressif"};
    srand(time(NULL)); // initialisation de rand
    char* res[2000];
    //printf("La phrase : %s %s %s %s %s ", sujet[rand()%4], adjectif[rand()%4], verbe[rand()%5], complement[rand()%5], adjectif2[rand()%4] );
    strcat(res, sujet[rand()%4]);
    strcat(res, " ");
    strcat(res, adjectif[rand()%4]);
    strcat(res, " ");
    strcat(res, verbe[rand()%4]);
    strcat(res, " ");
    strcat(res, complement[rand()%4]);
    strcat(res, " ");
    strcat(res, adjectif2[rand()%4]);
    return res;
}