/*********************************************************************
 *                                                                    *
 * FICHIER: UTIL                                                      *
 *                                                                    *
 * DESCRIPTION: fonctions appelées par client et serveur pour émettre *
 *              et recevoir des données                               *
 *                                                                    *
 *                                                                    *
 *********************************************************************/
#include    <errno.h>

/*
 * Ecrire  "n" octets vers un descripteur de socket
 */
int writen (int  fd, char *ptr, int nbytes)
{
  int nleft, nwritten; 
  char *tmpptr;

  nleft = nbytes;
  tmpptr=ptr;
  while (nleft >0) {
    nwritten = write (fd,ptr, nleft);
    if (nwritten <=0) {
      if(errno == EINTR)
	nwritten=0;
      else{
	perror("probleme  dans write\n");
	return(-1);
      }
    }
    nleft -= nwritten;
    ptr += nwritten;
  }
  return (nbytes);
}


/*
 * Lire  "n" octets à partir d'un descripteur de socket
 */
int readn (int  fd, char *ptr, int maxlen)
{
  char *tmpptr;
  int nleft, nreadn;

  nleft = maxlen;
  tmpptr=ptr;
  
  while (nleft >0) {
    nreadn = read (fd,ptr, nleft);
    if (nreadn < 0) {
      if(errno == EINTR)
	nreadn=0;
      else{
	perror("readn : probleme  dans read \n");
	return(-1);
      }
    }
    else if(nreadn == 0){
      /* EOF */ 
      break ;
    }
    nleft -= nreadn;
    ptr += nreadn;
  }
  return (maxlen - nleft);
}

/*
 * Lire  une ligne terminee par \n à partir d'un descripteur de socket
 */
int readline (int  fd, char *ptr, int maxlen)
{
  
  int n, rc, retvalue, encore=1;  char c, *tmpptr; 

  tmpptr=ptr;
  for (n=1; (n < maxlen) && (encore) ; n++) {
    if ( (rc = read (fd, &c, 1)) ==1) {
      *tmpptr++ =c; 
      if (c == '\n')  /* fin de ligne atteinte */
	{encore =0; retvalue = n;}
    }
    else if (rc ==0) {  /* plus rien à lire */
      encore = 0;
      if (n==1) retvalue = 0;  /* rien a été lu */
      else retvalue = n;
    }
    else { /*rc <0 */
      if (errno != EINTR) {
	encore = 0;
	retvalue = -1;
      }
    }
  }
  *tmpptr = '\0';  /* pour terminer la ligne */
  return (retvalue);
}

