#include "vecteur.h"
#include "utils_vecteur.h"
#include "memory_operations.h"
#include <stdio.h>

int main()
{
  vecteur v1,v2;
  int taille;

  v1 = lit_vecteur("vecteur1.txt");
  affiche_vecteur(v1);
  taille = taille_vecteur(v1);
  v2 = allouer_vecteur(taille);
  my_memcpy(acces_vecteur(v2,0), acces_vecteur(v1,0),taille*sizeof(double));
  my_memmove(acces_vecteur(v2,0), acces_vecteur(v2,taille/4), (taille/2)*sizeof(double));
  affiche_vecteur(v2);
  my_memcpy(acces_vecteur(v2,0), acces_vecteur(v1,0),taille*sizeof(double));
  my_memmove(acces_vecteur(v2,taille/4), acces_vecteur(v2,0), (taille/2)*sizeof(double));
  affiche_vecteur(v2);
  liberer_vecteur(v1);
  liberer_vecteur(v2);

  printf("Difference malloc/free : %d\n",malloc_counter - free_counter);
  
  return 0;
}
