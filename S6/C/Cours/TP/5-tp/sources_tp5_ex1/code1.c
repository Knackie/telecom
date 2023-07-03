char f_1 (char cc)
{ char res ;
    if ((cc >= 'a')&&(cc <= 'z'))
       res = 'a' + ((cc - 'a') + 11) % 26 ;
    else if ((cc >= 'A')&&(cc <= 'Z'))  
       res = 'A' + ((cc - 'A') + 11) % 26 ;
    else res = '?' ;
    return (res) ;
}
