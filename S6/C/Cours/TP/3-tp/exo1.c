#include <stdlib.h>
#include <stdio.h>

#define MAX 10
#define OFFSET(x, Y) ((unsigned int)&(Y.x)-(unsigned int)&(Y))

enum choix { XX, YY, ORIGIN };

typedef struct {
    int id;
    float x;
    float y;
} Point;

int symetrique(float* x, float* y, enum choix c) {

    int res = 0;

    if (c == XX) {
        *y *= -1;
        res = 1;
    } else if(c == YY) {
        *x *= -1;
        res = 1;
    } else if(c == ORIGIN) {
        *x *= -1;
        *y *= -1;
        res = 1;
    } 

    return res;
}

int symetrique_v2(Point *p, enum choix c) {

    int res = 0;

    if (c == XX) {
        p->y *= -1;
        res = 1;
    } else if(c == YY) {
        p->x *= -1;
        res = 1;
    } else if(c == ORIGIN) {
        p->x *= -1;
        p->y *= -1;
        res = 1;
    } 

    return res;
}

void afficher_point(Point p) {

    printf("%d(%.2f,%.2f)\n", p.id, p.x, p.y);
}

Point* initialiser_point(Point p) {
    
    Point* p2;
    p2 = malloc(sizeof(Point));
    p2->id = p.id; // p2->id équivaut à (*p2).id
    p2->x = p.x;
    p2->y = p.y;

    return p2;
}

void definir_droite(Point d[], Point A, Point B) {

    int i;
    float alpha, beta, pas;

    // calculer coeff directeur alpha
    alpha = (A.y-B.y)/(A.x-B.x);
    // calculer ordonnée à l'origine beta, on utilise les valeurs de A et B
    beta = A.y - alpha * A.x;

    // Pas pour échantilloner la fonction affine
    pas = (B.x-A.x)/(MAX-1);

    printf("Equation de la droite y = %.2f x + %.2f\n", alpha, beta);
    printf("Le pas sur l'axe des X est %.2f\n", pas);

    for (i=1; i < MAX-1; i++) {
        d[i].x = d[i-1].x + pas;
        d[i].y = alpha*d[i].x + beta;
        d[i].id = d[i-1].id + 1;
    }

    afficher_segment(d);
}

void afficher_segment(Point d[]) {

    for(int i=0; i < MAX-1; i++)
        afficher_point(d[i]);
}

int main(int argc, char const *argv[]) {

    // Question 1
    float x = 2.1;
    float y = 5.3;

    printf("X = %.2f, Y = %.2f\n", x , y);
    printf("Succes symetrie XX= %d\n", symetrique(&x, &y, XX));
    printf("X = %.2f, Y = %.2f\n", x , y);
    printf("Succes symetrie YY= %d\n", symetrique(&x, &y, YY));
    printf("X = %.2f, Y = %.2f\n", x , y);
    printf("Succes symetrie ORIGIN= %d\n", symetrique(&x, &y, ORIGIN));
    printf("X = %.2f, Y = %.2f\n", x , y);

    // Question 3
    Point p = { 12, 2.15, 5.68 };

    afficher_point(p);

    // Question 4
    Point *p2 = initialiser_point(p);

    afficher_point(*p2);

    // Question 5
    printf("Succes symetrie XX= %d\n", symetrique_v2(p2, XX));
    afficher_point(*p2);
    printf("Succes symetrie YY= %d\n", symetrique_v2(p2, YY));
    afficher_point(*p2);
    printf("Succes symetrie ORIGIN= %d\n", symetrique_v2(p2, ORIGIN));
    afficher_point(*p2);

    return 0;

    // Question 8
    printf("Taille du point p2 = %d", sizeof(p2));

}
