#include <stdio.h>

#define MAX 11
#define OFFSET(x,Y) ((unsigned int)&(Y.x)-(unsigned int)&(Y))

enum sym {XX,YY,ORIG};

struct Point {
    short int id;
    float x;
    float y;
};

void AffichePoint(struct Point point){
    printf("%d (%.2f,%.2f)\n", point.id, point.x, point.y);
}

void LirePoint(int id, float x, float y, struct Point *point){
    point->id = id;
    point->x = x;
    point->y = y;
}

void afficheSegment(struct Point d[]){
    int i;
    for (i=0;i<MAX;i++){
        AffichePoint(d[i]);
    }
}

int symetrique(enum sym option,  float *x, float *y) {
    switch (option) {
        case XX:
            *y = -*y;
            return 1;
        case YY:
            *x = -*x;
            return 1;
        case ORIG:
            *x = -*x;
            *y = -*y;
            return 1;
        default:
            return  0;
    }
}

int symetrique2(enum sym option,  struct Point *point) {
    switch (option) {
        case XX:
            point->y = -point->y;
            return 1;
        case YY:
            point->x = -point->x;
            return 1;
        case ORIG:
            point->y = -point->y;
            point->x = -point->x;
            return 1;
        default:
            return  0;
    }
}

void defDroite(struct Point d[], struct Point A, struct Point B){
    int i;
    float alpha, beta, pas;
    alpha = (A.y-B.y)/(A.x-B.x);
    beta = A.y - alpha * A.x;
    pas = (B.x - A.x)/(MAX-1);
    for (i=1;i<MAX-1;i++){
        d[i].x = d[i-1].x + pas;
        d[i].y = alpha*d[i].x + beta;
        d[i].id = d[i-1].id + 1;
    }
}

int main() {
   
    return 0;
}