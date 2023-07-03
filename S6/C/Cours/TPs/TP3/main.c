//Standard library
#include <stdio.h>
#include <string.h>

//Personnal Library
#include "Exercice1.h"
#include "Exercice2.h"


int main() {
    int num = 13;
    switch(num){
        case 0 : {
            enum options opt;
            opt = XX;
            int res = symetrique(0, 2, opt);
            printf("Resultat : %i", res);
            break;
        }
        case 1 : {
            Point p;
            p.id = 0;
            p.x = 32;
            p.y = 54;
            affichagePoint(p);
            break;
        }
        case 2 : {
            Point p;
            initPoint(&p);
            affichagePoint(p);
            break;
        }
        case 3 : {
            NULL;
        }
        case 10 : {
            Personne *p = creationPersonne("Millardet", "+33601010231");
            printf("La personne \"%s\" à le numéro : %s ", p->nom, p->numero);
            break;
        }
        case 11 : {
            Personne p;
            strcat(p.numero,"+33613815722");
            strcat(p.nom, "Millardet Franck");
            affichagePersonne(&p);
            break;
        }
        case 12 : {
            Annuaire *a = creationAnnuaire();
            Personne *p = creationPersonne("Wenzel Pierre","+33000000000" );
            ajoutAnnuaire(a, *p);
            break;
        }
        case 13 : {
            Annuaire *a = creationAnnuaire();
            Personne *p = creationPersonne("Wenzel Pierre","+33000000000" );
            ajoutAnnuaire(a, *p);
            affichageAnnuaire(a);
            break;
        }
        default:
            NULL;
            break;
    }
}