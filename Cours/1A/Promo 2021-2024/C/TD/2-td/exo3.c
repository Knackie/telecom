#include <stdio.h>

char *PremierChar(char c, char *ptrCar) {
    do
        if (*ptrCar == c)
            return (ptrCar);
    while (*ptrCar++ != '\O');

    return NULL;
}


int main(int argc, char const *argv[]) {
    /* code */

    char c, *str, *adrPremCar;

    c = argv[1][0];
    str = argv[2];

    if( (adrPremCar = PremierChar(c, str)) == NULL)
        printf("'%c' n'est pas dans %s.\n", c, str);
    else
        printf("La premiere occurence de '%c' dans %s est en position %d. \n", c, str, adrPremCar - str);

    return 0;
}
