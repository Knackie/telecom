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
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 80

usage(){
  printf("usage : servecho numero_port_serveur\n");
}


int main (int argc, char *argv[])

{
  int serverSocket, clientSocket; /* declaration socket passive et socket active */

  int n, retread, childpid;
  socklen_t clilen;
  struct sockaddr_in  serv_addr, cli_addr;
    char fromClient[MAXLINE];
  char fromUser[MAXLINE];

  /* Verifier le nombre de paramètre en entrée */
  /* serverTCP <numero_port>                   */ 
  if (argc != 2){
    usage();
    exit(1);
  }

   /*
   * Ouvrir une socket (a TCP socket)
   */
  if ((serverSocket = socket(PF_INET, SOCK_STREAM, 0)) <0) {
   perror("servecho : Probleme socket\n");
   exit (2);
  }

  /*
   * Lier l'adresse  locale à la socket
   */
  memset( (char*) &serv_addr,0, sizeof(serv_addr) );
  serv_addr.sin_family = PF_INET;
  serv_addr.sin_addr.s_addr = htonl (INADDR_ANY);
  serv_addr.sin_port = htons(atoi(argv[1]));

 
  if (bind(serverSocket,(struct sockaddr *)&serv_addr, sizeof(serv_addr) ) <0) {
   perror ("servecho: erreur bind\n");
   exit (1);
  }
  
  /* Paramètrer le nombre de connexion "pending" */
  if (listen(serverSocket, SOMAXCONN) <0) {
    perror ("servecho: erreur listen\n");
    exit (1);
  }


  clilen = sizeof(cli_addr);
  clientSocket = accept(serverSocket, (struct sockaddr *) &cli_addr, &clilen);
  if (clientSocket < 0) {
    perror("servecho : erreur accept\n");
    exit (1);
  }


  /* Envoyer Bonjour au client */
  if ( (n= writen (clientSocket, "Bonjour\n", strlen("Bonjour\n")) ) != strlen("Bonjour\n"))  {
	printf ("erreur writen");
	exit (1);
     }

  while ( (retread=readline (clientSocket, fromClient, MAXLINE)) > 0)
    {
      printf ("corr: %s", fromClient);
      if (strcmp (fromClient,"Au revoir\n") == 0) 
	break ; /* fin de la lecture */
      
      /* saisir message utilisateur */
      printf("vous: ");
      if (fgets(fromUser, MAXLINE,stdin) == NULL) {
	perror ("erreur fgets \n");
	exit(1);
      }
      
      /* Envoyer le message au client */
      if ( (n= writen (clientSocket, fromUser, strlen(fromUser), 0) ) != strlen(fromUser))  {
	printf ("erreur writen");
	exit (1);
     }

    }

  if(retread < 0 ) {
    perror ("erreur readline \n");
    //   exit(1);
  }
  close(serverSocket);
  close(serverSocket);
  

}
