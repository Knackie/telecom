char f_2 (char cc, int i)
{ char res ; int decalage ;
    switch (i)
    { case 1 : decalage = 11 ; break ;
      case 2 : decalage = 4 ; break ;
      case 3 : decalage = 14 ; break ;
      case 4 : decalage = 13 ; break ;
    }
  
    if ((cc >= 'a')&&(cc <= 'z'))
       res = 'a' + ((cc - 'a') + decalage) % 26 ;
    else if ((cc >= 'A')&&(cc <= 'Z'))  
       res = 'A' + ((cc - 'A') + decalage) % 26 ;
    else res = '?' ;
    return (res) ;
}
