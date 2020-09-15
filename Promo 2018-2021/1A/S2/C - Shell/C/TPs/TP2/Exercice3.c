//
// Created by Quentin Millardet on 2019-01-21.
//

#include <printf.h>

int first_occurrence(char* chaine_de_caratere, char caractere){
    for(int i=0; i<sizeof (chaine_de_caratere) / sizeof(chaine_de_caratere[0]) ; i++ ){
        if (chaine_de_caratere[i] == caractere){
            return i;
        }
    }
    return 0;
}

int last_occurrence(char* chaine_de_caratere, char caractere){
    for(int i=(sizeof (chaine_de_caratere) / sizeof(chaine_de_caratere[0])); i>=0 ; i-- ){
        if (chaine_de_caratere[i] == caractere){
            return i;
        }
    }
    return 0;
}