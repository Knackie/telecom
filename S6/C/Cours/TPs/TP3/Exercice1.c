//
// Created by Quentin Millardet on 2019-01-28.
//

#include <printf.h>

enum options{
    XX,XY,ORIG
};

typedef struct Point{
    int id;
    float x;
    float y;
}Point;

int symetrique(int x, int y, enum options opt) {
    if (opt == XX){
        y = -y;
        return 1;
    } else{
        if(opt == XY){
            x = -x;
            return 1;
        }
        else{
            if(opt == ORIG) {
                x = -x;
                y = -y;
                return 1;
            }
        }
    }
    return 0;
}

void affichagePoint(struct Point p){
    printf("%i(%f,%f)",p.id, p.x, p.y);
}

void initPoint(Point *p){
    p->id = 0;
    p->x = 0.0;
    p->y = 0.0;
}


int symetriqueQuestion5(Point *p, enum options opt) {
    int x = p->x;
    int y = p->y;
    if (opt == XX){
        y = -y;
        return 1;
    } else{
        if(opt == XY){
            x = -x;
            return 1;
        }
        else{
            if(opt == ORIG) {
                x = -x;
                y = -y;
                return 1;
            }
        }
    }
    return 0;
}