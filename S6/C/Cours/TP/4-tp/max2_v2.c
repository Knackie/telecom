#include <stdio.h>

int maximum (int x, int y)
{
  if (x > y) 
     return (x) ;
  else 
     return (y) ;
}

main(int argc, char *argv[]) 
{ int a, b , c ;
  /*printf("Donnez deux entiers decimaux : ") ;
  scanf("%d%d", &a, &b) ;*/
  if (argc != 3) return 0 ;
  a = argv[1] ;
  b = argv[2] ;
  c = maximum (a, b) ;
  printf("Le plus grand des deux entiers %d et %d est %d\n", a, b, c) ;
  return 0 ;
}
