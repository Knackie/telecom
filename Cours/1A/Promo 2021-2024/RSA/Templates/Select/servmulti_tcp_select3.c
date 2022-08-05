/*********************************************************************
 *                                                                   *
 * FICHIER: SERVER_TCP                                               *
 *                                                                   *
 * DESCRIPTION: Utilisation de TCP socket par une application serveur*
 *              application client                                   *
 *                                                                   *
 * principaux appels (du point de vue serveur) pour un protocole     *
 * oriente connexion:                                                *
 *     socket()                                                      *
 *                                                                   * 
 *     bind()                                                        *
 *                                                                   * 
 *     listen()                                                      *
 *                                                                   *
 *     accept()                                                      *
 *                                                                   *
 *     read()                                                        *
 *                                                                   *
 *     write()                                                       *
 *                                                                   *
 *********************************************************************/
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/select.h>

#define BUFSIZE 1500
int str_echo (int sockfd)
{
  int nrcv, nsnd;
  char msg[BUFSIZE];

  /*    * Attendre  le message envoye par le client 
   */
  memset( (char*) msg, 0, sizeof(msg) );
  if ( (nrcv= read ( sockfd, msg, sizeof(msg)-1) ) < 0 )  {
    perror ("servmulti : : readn error on socket");
    exit (1);
  }
  msg[nrcv]='\0';
  printf ("servmulti :message recu=%s du processus %d nrcv = %d \n",msg,getpid(), nrcv);

  if ( (nsnd = write (sockfd, msg, nrcv) ) <0 ) {
    printf ("servmulti : writen error on socket");
    exit (1);
  }
  printf ("nsnd = %d \n", nsnd);
  return (nsnd);
} /* end of function */


usage(){
  printf("usage : servmulti numero_port_serveur\n");
}


int main (int argc,char *argv[])

{
  int sockfd, n, newsockfd, childpid, servlen,fin;
  struct sockaddr_in  serv_addr, cli_addr;
  socklen_t clilen;
  int tab_clients[FD_SETSIZE];
  fd_set rset;
  int maxfdp1, nbfd, minindex, i, sockcli;

 /* Verifier le nombre de param�tre en entr�e */
  if (argc != 2){
    usage();
    exit(1);}


/*
 * Ouvrir une socket (a TCP socket)
 */
if ((sockfd = socket(PF_INET, SOCK_STREAM, 0)) <0) {
   perror("servmulti : Probleme socket\n");
   exit (2);
 }

 
/*
 * Lier l'adresse  locale � la socket
 */
 memset( (char*) &serv_addr,0, sizeof(serv_addr) );
 serv_addr.sin_family = PF_INET;
 serv_addr.sin_addr.s_addr = htonl (INADDR_ANY);
 serv_addr.sin_port = htons(atoi(argv[1]));
 
 
 if (bind(sockfd,(struct sockaddr *)&serv_addr, sizeof(serv_addr) ) <0) {
   perror ("servmulti : erreur bind\n");
   exit (1);
 }

/* Param�trer le nombre de connexion "pending" */
 if (listen(sockfd, SOMAXCONN) <0) {
   perror ("servmulti : erreur listen\n");
   exit (1);
 }

 maxfdp1 = sockfd+1;
 for(i=0;i<FD_SETSIZE; i++) {
   tab_clients[i] = -1;
 }
 minindex = -1;
 FD_ZERO(&rset);
 FD_SET(sockfd,&rset);

 for (;;) {
   
   if((nbfd = select(maxfdp1,&rset,NULL,NULL,NULL)) < 0) {
     perror("servselect : pb select \n");
     exit(1);
   };
   if (FD_ISSET(sockfd,&rset)) {
    // une demande de connexion a été émise par le client
    clilen = sizeof(cli_addr);
    newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr,  &clilen);
    if (newsockfd < 0) {
      perror("servmulti : erreur accept\n");
      exit (1);
    }
    i=0;
    while((i<FD_SETSIZE) && (tab_clients[i] >=0)) i++;
    if(i==FD_SETSIZE) {
      perror("trop de clients \n");
      exit(1);
    }
    tab_clients[i] = newsockfd;
    FD_SET(newsockfd, &rset);
    if (i>minindex) minindex = i;
    if (newsockfd >= maxfdp1) maxfdp1 = newsockfd+1;
    nbfd--;
   }

   i=0; 
   while ((nbfd > 0 && i<=minindex)) {
    if(((sockcli = tab_clients[i]) >=0) && (FD_ISSET(sockcli, &rset))) {
      if(str_echo(sockcli) == 0) {
        close(sockcli);
        tab_clients[i] = -1;
        FD_CLR(sockcli,&rset);
      }
      nbfd--;
    }
    i++;
   }
 }
}



















