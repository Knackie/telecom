#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
    malloc : allocation dynamique de mémoire pour réserver une taille en octet
            --> créer un tableau de n cases
            --> retourne un pointeur vers la mémoire allouée
    sizeof : opérateur qui retourne la taille en octets d'une donnée
    free : libérer la mémoire allouée
*/

#define MAX_CAR 10

typedef struct {
    char nomPlanete[MAX_CAR];
    int rayon;
} Planete;


void Saisir(Planete* pt) {

    printf("Entrez le nom de la planete : ");
    scanf("%s", pt->nomPlanete);
    // Pas besoin de & car nomPlanete est une string, donc une adresse vers une chaîne de caractères
    printf("Entrez le rayon de la planete : ");
    // Par contre rayon est un int, donc besoin d'utiliser & 
    scanf("%d", &pt->rayon);
}

Planete* Dupliquer(Planete p) {
    Planete* pl;
    pl = malloc(sizeof(Planete));
    // (*p). équivaut à p->
    // strcpy(cible, source)
    strcpy(pl->nomPlanete, p.nomPlanete);
    pl->rayon = p.rayon;
    return pl;
}

int main(int argc, char const *argv[]) {    
    Planete p;
    Planete *ptr_p;
    Saisir(&p);
    printf("%s %d \n", p.nomPlanete, p.rayon);
    ptr_p = Dupliquer(p);
    printf("%s %d \n", ptr_p->nomPlanete, ptr_p->rayon);
}


/*
    Référence           Type
    ptr_p               Planete*
    *ptr_p              Planete
    ptr_p->nomPlanete   char[]
    ptr_p->rayon        int
    p                   Planete
    &p                  Planete*
    p.nomPlanete        char[]
    p.rayon             int
*/
