//
// Created by Quentin Millardet on 2019-01-15.
//

void echange(int *x, int *y){
    int a = *x;
    *x = *y;
    *y = a;
}

int mainExercice1(){
    int a = 0;
    int b = 42;
    printf("Avant la fonction : \n     a : %d, b : %d \n", a, b);
    echange(&a, &b);
    printf("Avant le programme : \n     a : %d, b : %d \n", a, b);
    return 0;
}