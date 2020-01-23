//
// Created by Quentin Millardet on 2019-01-31.
//

#include <stdio.h>

int copieFichiers(char* src, char* dest){
    FILE *fw;
    FILE *fr;
    int texte;
    fr = fopen (src, "r+");
    fw = fopen (dest, "w+");
    if(fr!=NULL){
        texte = fgetc(fr);
        while(texte != -1){
            fputc(texte, fw);
            texte = fgetc(fr);
        }
    }
    return 0;
}