//
// Created by Quentin Millardet on 2019-01-28.
//

#ifndef TP3_EXERCICE1_H
#define TP3_EXERCICE1_H

enum options{
    XX,XY,ORIG
};

typedef struct Point{
    int id;
    float x;
    float y;
}Point;

int symetrique(int x, int y, enum options opt);

int symetriqueQuestion5(Point p, enum options opt);

void affichagePoint(Point p);

void initPoint(Point *p);

#endif //TP3_EXERCICE1_H
