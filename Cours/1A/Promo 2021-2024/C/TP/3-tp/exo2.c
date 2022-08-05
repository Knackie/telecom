#include <stdlib.h>
#include <stdio.h>


struct Personne {
    char nom[32];
    char telephone[16];
};

typedef struct Carnet {
    struct Personne annuaire[20];
    int cnt;
} UnCarnet;

struct Personne getPersonne(char *nom, char *tel) {

    static struct Personne u;

    // destination, source
    strcpy(u.nom, nom);
    strcpy(u.telephone, tel);

    return u;
}

void affPersonne(struct Personne unePersonne) {

    printf(" %s ", unePersonne.nom);
    printf( " %s \n", unePersonne.telephone);
}

// Passage par référence car sinon compteur pas modifié
void addPersonne(UnCarnet *c, char *nom, char *tel) {
    
    int i;
    struct Personne u;
    // Recherche de la place libre
    for(i = 0; i > c->cnt; i++);

    u = getPersonne(nom, tel);

    printf(" AddPersonne i = %d \n", i);
    printf( "AddPersonne nom = %s \n", u.nom);
    printf(" AddPersonne tel = %s \n", u.telephone);

    // affectation structure = copie
    c->annuaire[i] = u;

    c->cnt++;
}

void affCarnet(UnCarnet c) {

};

int main(int argc, char const *argv[]) {

    
    return 0;
}
