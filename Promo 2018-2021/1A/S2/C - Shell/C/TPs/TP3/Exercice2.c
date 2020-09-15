//
// Created by Quentin Millardet on 2019-01-28.
//

#include <string.h>
#include <printf.h>

typedef struct Personne {
    char nom[32];
    char numero[17];
}Personne;

typedef struct Annuaire{
    Personne* personnes[21];
    int ind;
}Annuaire;


Personne* creationPersonne(char nom[33], char telephonne[17]){
    static Personne p;
    strcat(p.nom, nom);
    strcat(p.numero, telephonne);
    return &p;
}

void affichagePersonne(Personne* p){
    printf("M. %s : %s", p->nom, p->numero);
}

Annuaire* creationAnnuaire() {
    static Annuaire result;
    result.ind=0;
    return &result;
}

int ajoutAnnuaire(Annuaire* a,Personne p){
    if(a->ind == 21){
        printf("L\'annauraire est déjà remplis");
        return 1;
    }
    else{
        int indice = a->ind;
        a->personnes[indice] = &p;
        a->ind += 1;
    }
    return 0;
}

int affichageAnnuaire(Annuaire* a){
    for(int i=0; i<a->ind; i++){
        affichagePersonne(a->personnes[i]);
        printf("\n");
    }
    return 0;
}