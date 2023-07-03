#include <stdio.h>

/*

	Pointeur : variable contenant l'adresse d'une autre variable
	%p -> affiche une adresse de variable ou pointeur

	[VARIABLES]
		maVariable : valeur de la variable
		&maVariable : adresse de la variable

	[POINTEURS]
		*monPointeur = NULL ou  *monPointeur = &maVariable
		(déclaration et initialisation d'un pointeur)

		monPointeur : adresse de la variable pointée
		*monPointeur : valeur de la variable pointée
		&monPointeur : adresse du pointeur
*/

void inverser_nombres(int *pt_nb1, int *pt_nb2) {

	int tmp = 0;
	tmp = *pt_nb2;
	*pt_nb2 = *pt_nb1;
	*pt_nb1 = tmp;
}

void change_nombre(int *nb) {

	*nb = 30;
}


int main(){
	int nbA = 15;
	int nbB = 20;

	int *pt_nbA = &nbA;
	int *pt_nbB = &nbB;
    
	printf("AVANT : A = %d et B = %d\n", nbA, nbB);
	change_nombre(&nbA);
	inverser_nombres(pt_nbA,pt_nbB);
	printf("APRES : A = %d et B = %d\n", nbA, nbB);
}