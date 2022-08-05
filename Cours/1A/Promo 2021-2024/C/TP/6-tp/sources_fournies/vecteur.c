#include "vecteur.h"
#include <stdlib.h> 
#include <stdio.h>

vecteur allouer_vecteur(int taille)
{
  vecteur v;
  v.donnees = (double *)malloc(taille * sizeof(double));

  if (v.donnees == NULL)
    v.taille = 0;
  else
    v.taille = taille;

  return v;
}

void liberer_vecteur(vecteur v)
{
  free(v.donnees);
}

int est_vecteur_invalide(vecteur v)
{
  return v.taille <= 0 ? 1 : 0;
}

double *acces_vecteur(vecteur v, int i)
{
  if (i < 0 || i >= v.taille)
    return NULL;
  else {
    double *resultat;
    resultat = &(v.donnees[i]);
  // resultat = v.donnes + i;
    return resultat;
  }
}

int taille_vecteur(vecteur v)
{
  return v.taille;
}
