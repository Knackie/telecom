#include "utils_matrice.h"
#include <stdio.h>

int main()
{
  matrice m1,m2;

  m1 = lit_matrice("matrice1.txt");
  affiche_matrice(m1);
  liberer_matrice(m1);
  m2 = lit_matrice("matrice2.txt");
  affiche_matrice(m2);
  liberer_matrice(m2);

  printf("Difference malloc/free : %d\n",malloc_counter - free_counter);
  
  return 0;
}
