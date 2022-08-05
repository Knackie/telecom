#include <stdio.h>
#include <stdlib.h>

int *tab = NULL;

void initialise(int n) {
  int i;

  for (i = 0; i < n; i++)
    {
       tab[i] = 1;
    }
}
  
int main() {
  printf("Debut\n");
  tab = malloc(10000*sizeof(int));
  initialise(10000);
  //free(tab);
  printf("Fin\n");
  return 0;
}
