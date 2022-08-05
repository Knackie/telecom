#include <stdio.h>

int main()
{
        /*
    char mot[] = "VACANCE";
    char *ptr, **ptr2;
    mot[1] = 'O'; // équivaut à *(mot + 1) = 'O'
    ptr = mot + 2; // mot équivant à &mot[0]
    printf("ptr = %s\n", ptr);
    *ptr = mot[0] + 3;
    ptr++;
    ptr2 = &ptr;
    **ptr2 = *(mot + 3); // *(mot + 3) équivaut à mot[3]
    *(++*ptr2) = 'G'; // adresse de ptr va être incrémentée, elle pointait avant sur a[1], puis on pointe vers a[2] qu'on modifie avec 'G'
    *(ptr + 1) = *(*ptr2 + 2);
    *(ptr + 2) = 'S';
    printf("Nouveau mot %s \n", mot);   
    *(*ptr2++) = mot[7];
    printf("Nouveau mot %s \n", mot);
    */

    char mot[] = "hello";
    char *mot2 = "bonjour";
    char *mot3 = &mot[3];
    printf(mot);
    printf(mot2);
    printf(mot3);
}