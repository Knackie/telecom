#include<stdio.h>

int main()
{ int choix ; char texte[6] ;
  
  printf ("Choix du codage. Donnez un chiffre (1 ou 2) : ") ;
  scanf ("%d", &choix) ;
  printf ("Texte a coder. Donnez 5 caracteres exactement : ") ;
  scanf ("%s", texte) ;
  switch (choix)
  {
     case 1 :	printf ("%c", f_1(texte[0])) ;
		printf ("%c", f_1(texte[1])) ;
		printf ("%c", f_1(texte[2])) ;
		printf ("%c", f_1(texte[3])) ;
		printf ("%c", f_1(texte[4])) ;
		break ;
     case 2 :	printf ("%c", f_2(texte[0],1)) ;
                printf ("%c", f_2(texte[1],2)) ;
                printf ("%c", f_2(texte[2],3)) ;
                printf ("%c", f_2(texte[3],4)) ;
                printf ("%c", f_2(texte[4],1)) ;
		break ;
  }
  printf("\n") ;
return 0 ;
}

