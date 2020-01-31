/*********************************************************************
 *                                                                   *
 * FICHIER: CLIENT_TCP                                               *
 *                                                                   *
 * DESCRIPTION: Utilisation de TCP socket par une application client *
 *              avec le concept de donnee urgente                    *   
 *                                                                   *
 *********************************************************************/
#include     <stdio.h>
#include     <sys/types.h>
#include     <sys/socket.h>
#include     <netinet/in.h>
#include     <arpa/inet.h>
#include     <strings.h>
#include     <string.h>
#include      <netdb.h>
#include      <stdlib.h>

usage(){
  printf("usage : cliecho adresseIP_serveur(x.x.x.x)  numero_port_serveur\n");
}




int main (int argc, char *argv[])

{
  int serverSocket, n;
  struct sockaddr_in  serv_addr;
  struct hostent *hp; 
  char buff[16384];
 
  

  /* Verifier le nombre de paramètre en entrée */
  /* clientTCP <hostname> <numero_port>        */
  if (argc != 3){
    usage();
    exit(1);
    }


  /* 
   * Remplir la structure  serv_addr avec l'adresse du serveur 
   */
  memset ( (char *) &serv_addr,0, sizeof(serv_addr) );
  serv_addr.sin_family = PF_INET;
  serv_addr.sin_port = htons((uint16_t)atoi(argv[2]));
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


  n= send (serverSocket, "zzzzzzzzzzzz", 12,0);
  printf(" ecriture de %d \n", n);
  sleep(5);

  n= send (serverSocket, "abc", 3, MSG_OOB);
   printf(" ecriture de %d de OOB\n", n);
  sleep(5);

 n= send (serverSocket, "wwwwwwwwwwww", 12,0);
  printf(" ecriture de %d \n", n);
  sleep(5);

 n= send (serverSocket, "def", 3, MSG_OOB);
   printf(" ecriture de %d de OOB\n", n);
  sleep(5);

  close(serverSocket);
}
