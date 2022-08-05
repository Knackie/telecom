

/*********************************************************************
 *                                                                   *
 * FICHIER: CLIENT_UDP                                               *
 *                                                                   *
 * DESCRIPTION: Utilisation de UDP socket par une application client *
 *                                                                   *
 * principaux appels (du point de vue client)                        *
 *     socket()                                                      *
 *                                                                   *
 *     sendto()                                                      *
 *                                                                   *
 *     recvfrom()                                                    *
 *                                                                   *
 *********************************************************************/
#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/un.h>
#include <arpa/inet.h>
#include <sys/uio.h>
#include <time.h>
#include <sys/timeb.h>
#include <netdb.h>
#include <stdlib.h>
#include <strings.h>

#define MAXLINE 80
usage()
{
  printf("usage : cliecho adresseIP_serveur(x.x.x.x)  numero_port_serveur\n");
}

int main(int argc, char *argv[])

{
  int serverSocket, unixSocket, n, retread;
  struct sockaddr_in serv_addr;
  struct sockaddr_un unixAddr;
  char *data;
  char sendbuf[1500];
  struct timeb tp;
  struct hostent *hp;
  int ttl;
  socklen_t len = sizeof(serv_addr);

  /* Verifier le nombre de param�tre en entr�e */
  /* clientUDP <hostname> <numero_port>        */
  if (argc != 3)
  {
    usage();
    exit(1);
  }

  /*
   * Remplir la structure  serv_addr avec l'adresse du serveur
   */
  memset((char *)&serv_addr, 0, sizeof(serv_addr));
  serv_addr.sin_family = PF_INET;
  serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
  serv_addr.sin_port = htons(atoi(argv[2]));

  hp = (struct hostent *)gethostbyname(argv[1]);
  if (hp == NULL)
  {
    fprintf(stderr, "%s: %s non trouve dans in /etc/hosts ou dans le DNS\n",
            argv[0], argv[1]);
    exit(1);
  }
  //  bcopy( (char *) hp->h_addr,  (char *)& serv_addr.sin_addr, hp->h_length);
  memcpy(&serv_addr.sin_addr, hp->h_addr, hp->h_length);
  printf("IP address: %s\n", inet_ntoa(serv_addr.sin_addr));

  /*
   * Ouvrir socket UDP
   */
  if ((serverSocket = socket(PF_INET, SOCK_DGRAM, 0)) < 0)
  {
    perror("erreur socket");
    exit(1);
  }

  ttl = 1;
  if (setsockopt(serverSocket, IPPROTO_IP, IP_TTL, &ttl, sizeof(ttl)) < 0)
  {
    perror("setsockopt");
    exit(1);
  }

  ftime(&tp);
  data = ctime(&tp.time);

  if ((n = sendto(serverSocket, data, strlen(data), 0,
                  (struct sockaddr *)&serv_addr, sizeof(serv_addr))) != strlen(data))
  {
    perror("erreur sendto");
    exit(1);
  }

  if ((n = recvfrom(serverSocket, sendbuf, sizeof(sendbuf) - 1, 0,
                    (struct sockaddr *)&serv_addr, &len)) != strlen(data))
  {
    printf("erreur sendto");
    exit(1);
  }

  sendbuf[n] = '\0';
  printf("Message re�u du serveur %s \n", sendbuf);
  close(serverSocket);
}
