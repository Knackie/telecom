#include "vecteur_dynamique.h"
#include "utils_vecteur.h"
#include <stdio.h>
#include <math.h>

int main()
{
  vecteur v1,v2;
  int i, limite;

  v1 = lit_vecteur("vecteur1.txt");
  limite = taille_vecteur(v1);
  for (i=-100; i<limite+100; i++)
      if (acces_vecteur(v1,i)!=NULL)
          *acces_vecteur(v1,i) = i%10;
  for (i=-100; i<limite+100; i++)
      if (acces_vecteur(v1,i)!=NULL)
          printf("%g",*acces_vecteur(v1,i));
  printf("\n");
  liberer_vecteur(v1);
  v2 = lit_vecteur("vecteur2.txt");
  limite = taille_vecteur(v2);
  for (i=limite+100; i>-100; i--)
      if (acces_vecteur(v2,i)!=NULL)
          *acces_vecteur(v2,i) = i%10;
  for (i=limite+100; i>-100; i--)
      if (acces_vecteur(v2,i)!=NULL)
          printf("%g",*acces_vecteur(v2,i));
  printf("\n");
  liberer_vecteur(v2);

  printf("Difference malloc/free : %d\n",malloc_counter - free_counter);
  
  return 0;
}
