#include "matrice_lineaire.h"
#include <stdlib.h>

matrice allouer_matrice(int l, int c)
{
  matrice m;
  m.donnees = (double *) malloc(l*c*sizeof(double));

  if (m.donnees == NULL) {
    m.l = 0;
    m.c = 0;
  } else {
    m.l = l;
    m.c = c;
  }

  return m;
}

void liberer_matrice(matrice m)
{
  free(m.donnees);
}

int est_matrice_invalide(matrice m)
{
  return (m.l <= 0 || m.c <= 0) ? 1 : 0;
}

double *acces_matrice(matrice m, int i, int j)
{
  double *resultat;
  resultat = &(m.donnees[(m.l*i)+j]);

  return resultat;
}

int nb_lignes_matrice(matrice m)
{
  return m.l;
}

int nb_colonnes_matrice(matrice m)
{
  return m.c;
}
