#include <stdio.h>
#include <stdlib.h>


/*
	[Declaration tableau]
		<type> <nom_tableau>[X] // Declare avec des valeurs aléatoires

	[Initialisation]
		tableau[5] = {valeur1, valeur2, valeur3, valeur4, valeur5};
		tableau[5] = {0}; //Toutes les cases valent 0
		tableau[5] = {4}; //Première case vaut 4, les autres valent 0

	[Accès au tableau]
		tableau[X] : élement d'indice X (X+1ème élément du tableau )	

		tableau  : adresse du tableau
		*tableau : premier élément du tableau
		*(tableau + X) : élément indice X

	[NOTE]
		tableau[5] même chose que *(tableau + 5)
*/
#define TAILLE_TAB 5
#define NOMBRES_LIGNES 3
#define NOMBRE_COLONNES 2

void afficher_tableau(int *tab, int taille){
	for(int i=0;i<taille;i++)
		printf("[%d] ",tab[i]);
}

int* creer_tableau(){

	static int tabInt[5];
	for(int i=0;i<5;i++){
		tabInt[i] = rand()%10; 
	}
	return tabInt;
}

int main(){

	int damier[NOMBRES_LIGNES][NOMBRE_COLONNES] = {{1,2},{3,4},{5,6}};
	for (int i=0; i < NOMBRES_LIGNES;i++)
		for (int j = 0; j < NOMBRE_COLONNES; j++)
			printf("Element indice [%d][%d] = %d\n",i,j,damier[i][j]);
		
	return 0;
}