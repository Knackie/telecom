#include "utils_matrice.h"
#include <stdio.h>
#include <stdlib.h>

matrice construit_matrice(int l, int c, double *donnees)
{
  matrice m;
  int i,j;

  m = allouer_matrice(l,c);
  if (est_matrice_invalide(m))
    {
      fprintf(stderr,"Erreur d'allocation du matrice\n");
      exit(1);
    }
  for (i=0; i<l; i++)
      for (j=0; j<c; j++)
          *acces_matrice(m,i,j) = donnees[i*c+j];
  return m;
}

void affiche_matrice(matrice m)
{
  int i,j;

  for (i=0; i<nb_lignes_matrice(m); i++)
    {
      printf("[ ");
      for (j=0; j<nb_colonnes_matrice(m); j++)
          printf("%g ",*acces_matrice(m,i,j));
      printf("]\n");
    }
}

matrice lit_matrice(char *fichier)
{
  matrice m;
  int i,j,l,c;
  FILE *f;

  f = fopen(fichier,"r");
  if (f == NULL)
    {
      fprintf(stderr,"Erreur d'ouverture du fichier de matrice %s\n",fichier);
      exit(1);
    }
  fscanf(f," %d %d",&l,&c);
  m = allouer_matrice(l,c);
  if (est_matrice_invalide(m))
    {
      fprintf(stderr,"Erreur d'allocation de la matrice\n");
      exit(2);
    }
  for (i=0; i<l; i++)
    {
      for (j=0; j<c; j++)
          fscanf(f," %lg", acces_matrice(m,i,j));
    }
  fclose(f);
  return m;
}
