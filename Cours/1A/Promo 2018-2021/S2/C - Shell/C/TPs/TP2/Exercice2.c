//
// Created by Quentin Millardet on 2019-01-21.
//

#include <printf.h>

char min2maj(char c){
    return (char) (c - 32);
}
char maj2min(char c){
    return (char) (c + 32);
    ;
}

char* inverseurCaractereMinMaj(){
    char entree[30];
    char static sortie[30];
    printf("Entrée votre mot : ");
    scanf("%s",&entree);
    for(int i=0; i<30 && entree[i]!='\0'; i++){
        if (entree[i]>96){
            sortie[i] = min2maj(entree[i]);
        }
        else{
            sortie[i] = maj2min(entree[i]);
        }
    }
    return sortie;
}