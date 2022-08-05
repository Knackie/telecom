#ifndef __MATRICE_DYNAMIQUE__
#define __MATRICE_DYNAMIQUE__

typedef struct donnees_matrice {
  int l,c;
  double **donnees;
} *matrice;

/*
   allouer_matrice
   description : alloue une matrice en memoire
   parametres : le nombre de lignes et de colones de la matrice
   valeur de retour : une matrice de la taille demandee si l'allocation s'est
                      bien passee et la matrice invalide si une erreur est survenue
   effets de bord : alloue de la memoire
*/
matrice allouer_matrice(int l, int c);

/*
   liberer_matrice
   description : libere une matrice precedemment allouee par alloue_matrice
   parametres : la matrice
   valeur de retour : aucune
   effets de bord : libere de la memoire
*/
void liberer_matrice(matrice m);

/*
   est_matrice_invalide
   description : retourne 1 si la matrice est invalide
   parametres : la matrice
   valeur de retour : 1 si la matrice est invalide 0 sinon
   effets de bord : libere de la memoire
*/
int est_matrice_invalide(matrice m);

/*
   acces_matrice
   description : retourne un pointeur vers l'element d'indice i de la matrice
   parametres : la matrice, les indices de l'element souhaite
   valeur de retour : un pointeur vers double
   effets de bord : aucun
*/
double *acces_matrice(matrice m, int i, int j);

/*
   nb_lignes_matrice
   description : retourne le nombre de lignes d'une matrice
   parametres : la matrice
   valeur de retour : le nombre de lignes
   effets de bord : aucun
*/
int nb_lignes_matrice(matrice m);

/*
   nb_colonnes_matrice
   description : retourne le nombre de colonnes d'une matrice
   parametres : la matrice
   valeur de retour : le nombre de colonnes
   effets de bord : aucun
*/
int nb_colonnes_matrice(matrice m);

#endif
