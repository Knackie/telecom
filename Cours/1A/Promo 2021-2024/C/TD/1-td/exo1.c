#include <stdlib.h>
#include <stdio.h>

/* Question 1

    Adresse         Valeur          Id
    0x00            5               a
    0x04            9               b
    0x08                            d
    0x0B            23              e
    0x14            x                *c
                    5               x
                    0x04            *y
                    23              z
                                    ade
*/

#define TAILLE_MAX 10 

void echange(int *x, int *y) {

	int tmp;
	tmp = *y;
	*y = *x;
	*x = tmp;
}

int *f(int a){
    // val contient l'adresse du tableau
    static int val[TAILLE_MAX];
    // Mot clé static car sinon retourne une adresse locale
    return val;
}


int test() {
    int a = 10;

    return a;
}

int main(int argc, char const *argv[]) {
    
    int x = test(); 

    int a = 5; int b = 25;

    printf("A = %d\nB = %d\n", a, b);
    echange(&a, &b);
    printf("A = %d\nB = %d", a, b);

    int* tab = f(5);

    // Question 4 
    // Allocation statique
    char ptr[100];
    gets(ptr);

    // Allocation dynamique
    char *ptr2;
    ptr2 = malloc(100*sizeof(char));
    gets(ptr2);

    return 0;
}
