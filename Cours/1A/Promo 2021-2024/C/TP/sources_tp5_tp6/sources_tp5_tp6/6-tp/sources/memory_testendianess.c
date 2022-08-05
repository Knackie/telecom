#include "memory_operations.h"
#include <stdio.h>

int main()
{
  char tableau[sizeof(int)];
  int *entier = (int *) tableau;
  int i;

  for (i=0; i<sizeof(int); i++)
      tableau[i] = 0;
  if (is_little_endian())
      tableau[0] = 1;
  else
      tableau[sizeof(int)-1] = 1;
  printf("Un : %d\nTruc bizarre : %x\n",*entier,reverse_endianess(0x01234567));

  printf("Difference malloc/free : %d\n",malloc_counter - free_counter);
  
  return 0;
}
