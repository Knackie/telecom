/*********************************************************************
 *                                                                   *
 * FICHIER: CLIENT_TCP                                               *
 *                                                                   *
 * DESCRIPTION: Utilisation de TCP socket par une application client *
 *                                                                   *
 * principaux appels (du point de vue client) pour un protocole      *
 * oriente connexion:                                                *
 *     socket()                                                      *
 *                                                                   * 
 *     connect()                                                     *
 *                                                                   *
 *     write()                                                       *
 *                                                                   *
 *     read()                                                        *
 *                                                                   *
 *********************************************************************/
#include     <stdio.h>
#include     <sys/types.h>
#include     <sys/socket.h>
#include     <netinet/in.h>
#include     <arpa/inet.h>
#include     <strings.h>
#include      <netdb.h>
#include      <stdlib.h>

#define MAXLINE 80
usage(){
  printf("usage : cliecho adresseIP_serveur(x.x.x.x)  numero_port_serveur\n");
}




int main (int argc, char *argv[])

{
  int serverSocket, servlen, n, retread;
  struct sockaddr_in  serv_addr;
  char fromServer[MAXLINE];
  char fromUser[MAXLINE];
  struct hostent *hp;  
  

  /* Verifier le nombre de paramètre en entrée */
  /* clientTCP <hostname> <numero_port>        */
  if (argc != 3){
    usage();
    exit(1);
    }


  
  /* 
   * Remplir la structure  serv_addr avec l'adresse du serveur 
   */
  memset ( (char *) &serv_addr, 0, sizeof(serv_addr) );
  serv_addr.sin_family = PF_INET;

  serv_addr.sin_port = htons(atoi(argv[2]));
  hp = (struct hostent *)gethostbyname (argv[1]);
  if (hp == NULL) {
    fprintf(stderr, "%s: %s non trouve dans in /etc/hosts ou dans le DNS\n",
            argv[0], argv[1]);
    exit(1);
  }

  serv_addr.sin_addr = * ((struct in_addr *)(hp->h_addr));
  printf ("IP address: %s\n", inet_ntoa (serv_addr.sin_addr));
  
   
  /*
   * Ouvrir socket (socket STREAM)
   */
  if ((serverSocket = socket(PF_INET, SOCK_STREAM, 0)) <0) {
    perror ("erreur socket");
    exit (1);
  }

  /*
   * Connect to the serveur 
   */
  if (connect (serverSocket, (struct sockaddr *) &serv_addr,  
	       sizeof(serv_addr) ) < 0){
     perror ("erreur connect");
    exit (1);
  }

  while ( (retread =readline (serverSocket, fromServer, MAXLINE)) > 0)
    {
      printf ("corr: %s", fromServer);
      if (strcmp (fromServer,"Au revoir\n") == 0) 
	break ; /* fin de la lecture */
      
      /* saisir message utilisateur */
      printf("vous: ");
      if (fgets(fromUser, MAXLINE,stdin) == NULL) {
	perror ("erreur fgets \n");
	exit(1);
      }
      
      /* Envoyer le message au serveur */
      if ( (n= writen (serverSocket, fromUser, strlen(fromUser)) ) != strlen(fromUser))  {
	printf ("erreur writen");
	exit (1);
      }
    }
  if(retread < 0 ) {
    	perror ("erreur readline \n");
	//	exit(1);
  }

  close(serverSocket);
}
