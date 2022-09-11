#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#define NB_PAGES (1<<10)
#define PAGE_SIZE (1<<12)
#define MAX (NB_PAGES*PAGE_SIZE)

char tab1[MAX];

int main (void){

  int i;
  
  char tab2[MAX];
  int  *px = malloc (MAX*sizeof(int));
    
  for (i=0; i<MAX; i++){
    tab1[i] = 'x';
    tab2[i] = 'y';
    px[i] = i;
  }

  printf ("l'adresse de  px[0] = %010p\n", &px[0]);
  printf ("l'adresse de  tab1[0] = %010p\n", &tab1[0]);
  printf ("l'adresse de  tab2[0] = %010p\n", &tab2[0]);

  printf ("memory map file: /proc/%d/maps\n", getpid());
  printf ("sleeping ...");
  fflush (NULL);
  sleep (20);

  free (px);

  exit (EXIT_SUCCESS);
}