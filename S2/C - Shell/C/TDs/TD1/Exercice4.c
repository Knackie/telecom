//
// Created by Quentin Millardet on 2019-01-15.
//
int mainExercice4(int argc, char *argv[]){
    char msg[9] = "bonjour !";
    char *adrMsg, *ptrCar, c;
    short longueur;

    /* Initialise adrMsg à l'adresse du 1er caractère 'b' de msg (adresse de début) */
    adrMsg = &msg[0];

    /* Instruction identique à adrMsg = &msg[0]; */
    adrMsg = msg;
    
    /* Initialise ptrCar à l'adresse du dernier caractère (nul) de msg */
    ptrCar = msg[8];

    /* ramène le pointeur sur le caractère '!' */
    int i = 0;
    for (int j = 0; !msg[i].isNull(); ++j) {
        i++;
    }
    i--;
    i--;
    ptrCar -= msg[i];

    /* Stoke la longueur de la chaine "jour" */
    longueur = 4 ;

    /* Stocke le caractère pointé par ptrCar dans la variable c */
    c=*ptrCar;

    /* Décrémente ptrCar, obtient le caractère 'r' et le range dans la variable c */
    ptrCar--;

    /* Ramène le pointeur sur le caractère '!' */
    ptrCar++;
    /* Stoke le caractère pointé par ptrCar ('!') dans c, puis incrémente prtCar */
    c = *ptrCar++;

    /* Stoke le caractère contenu par la varaible c à l'adresse du caractère 'j' */
    

}