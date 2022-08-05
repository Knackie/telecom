int a[] = {10, 20, 30, 40, 50};

main()
{
    int i, *pi, *pk, *b[2], **pl;
    pi = &a[0];
    pk = &a[1];
    pl = &pk;
    (*pl)--;
    **pl = 0;
    b[0] = &a[4];
    b[1] = b[0];
    b[0]--;
    b[0]--;
    *(b[0]) = 3;
    pi++;
    *pi = 4;
    a[a[2]] = 1;
    for (i = 0; i <= 4; i++)
        printf(" a[%d] = %d ", i, a[i]);
    printf("\n");
}