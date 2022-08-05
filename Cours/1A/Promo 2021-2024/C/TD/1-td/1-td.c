#include <stdio.h>

/* 
Question 1


*/

/* Question 2 */
void echange(int x, int y) {
    int* p = &x;
    y = x;
    x = p;
}

int main(int argc, char const *argv[]) {
    int x = 5;
    int y = 10;
    echange(x, y);
    printf("Value 1 = %d", x);
    printf("Value 2 = %d", y);
}
