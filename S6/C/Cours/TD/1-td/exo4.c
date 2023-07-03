int main(int argc, char *argv[])
{
    char msg[9] = "bonjour!";
    char *adrMsg, *ptrCar, c;
    short longueur;
    /* initialise adrMsg à l'adresse du 1er caractère 'b' de msg (adresse de début) */
    adrMsg = &msg[0];

    /* instruction identique à adrMsg = &msg[0]; */
    adrMsg = msg;

    /* initialise ptrCar à l'adresse du dernier caractère (nul) de msg */
    ptrCar = &msg[8];

    /* ramène le pointeur sur le caractère '!' */
    --ptrCar;

    /* stocke la longueur de la chaîne "jour" */
    longueur = (short) (ptrCar - adrMsg+3);

    /* stoke le caractère pointée par ptrCar dans la variable c */
    c = *ptrCar; // équivaut à c = msg[7] ou encore c = *(adrMsg + 7)

    /* décrémente ptrCar, obtient le caractére 'r' et le range dans la variable c */
    c = *--ptrCar;

    /* ramène le pointeur sur le caractère '!' */
    ++ptrCar;

    /* stocke le caractère pointée par ptrCar ('!') dans c, puis incréemente ptrCar */
    c = *ptrCar++;

    /* stocke le caractère contenu par la variable c à l'adresse du caractère 'j' */
    *(ptrCar - 5) = c;
}