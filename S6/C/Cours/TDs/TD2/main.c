#include <stdio.h>

int main() {
    char *couleur[6] = { "rouge", "vert", "bleu", "blanc", "noir", "jaune"};
    printf("%c", *(*(couleur+5)+6));
}