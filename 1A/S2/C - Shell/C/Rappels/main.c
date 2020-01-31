#include <stdio.h>

int main() {
    char mot[] = "NANCY";
    char *ptr, **ptr2;
    mot[1] = 'E';
    ptr = mot + 2;
    *ptr = mot[0] + 6;
    ptr++;
    ptr2 = &ptr;
    **ptr2= *(mot + 4) + 1;
    *(++*ptr2)=*(ptr+2);
    mot[0]= (char) (*mot - 1);
    printf("%s\n", mot);
    return 0;
}