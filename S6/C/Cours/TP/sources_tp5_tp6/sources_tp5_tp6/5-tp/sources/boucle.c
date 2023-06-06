#include <stdio.h>
#include <stdlib.h>

int *tab = NULL;

void initialise(int n) {
  char i = 0;

  for (i = 0; i <= n; i++);
    {
       tab[i] = 1;
    }
}
  
int main() {
  printf("Debut\n");
  tab = malloc(10000*sizeof(int));
  initialise(10000);
  printf("Fin\n");

  return 0;
}
