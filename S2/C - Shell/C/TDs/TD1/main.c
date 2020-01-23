#include <stdio.h>
#include "Exercice1.h"
#include "Exercice4.h"

int main() {
    char* car[5];
    choix = 0;
    switch(choix){
        case 0:
            mainExercice1();
            break;
        case 4:
            mainExercice4(0, car);
            break;
        default:
            break;
    }
    return 0;
}