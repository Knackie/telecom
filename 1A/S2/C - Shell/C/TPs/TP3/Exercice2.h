//
// Created by Quentin Millardet on 2019-01-28.
//

#ifndef TP3_EXERCICE2_H
#define TP3_EXERCICE2_H

typedef struct Personne {
    char nom[32];
    char numero[17];
}Personne;

typedef struct Annuaire{
    Personne* personnes[21];
    int ind;
}Annuaire;


Personne* creationPersonne(char* nom, char* telephonne);
void affichagePersonne(Personne* p);
Annuaire* creationAnnuaire();
int ajoutAnnuaire(Annuaire* a,Personne p);
int affichageAnnuaire(Annuaire* a);


#endif //TP3_EXERCICE2_H
