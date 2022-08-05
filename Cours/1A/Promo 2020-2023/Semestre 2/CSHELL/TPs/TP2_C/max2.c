#include <stdio.h>

int maximum (int x, int y)
{
  if (x > y) 
     return (x) ;
  else 
     return (y) ;
}

int main() 
{ int a, b , c ;
  printf("Donnez deux entiers decimaux : ") ;
  scanf("%d%d", &a, &b) ;
  c = maximum (a, b) ;
  printf("Le plus grand des deux entiers %d et %d est %d\n", a, b, c) ;
  return 0 ;
}
