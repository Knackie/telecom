#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>

#include <stdio.h>
#include <errno.h>

/* Si vous ne savez pas quels en-têtes ajouter,
   consulter le manuel de la fonction que vous souhaitez utiliser */

int main(int argc, char *argv[]) {
	/* La fonction socket() permet de créer une socket

	   Ici, on crée une socket IPv4 (AF_INET) utilisant une connexion fiable (TCP, option SOCK_STREAM)

	   Le troisième paramètre prend des options en fonction du protocole choisi, ici on a
	   aucune option particulière donc on met 0.
	   
	   Documentation de la fonction socket et des sockets en général :
	   $ man 2 socket
	   $ man 7 ip
	   $ man 7 ipv6
	   https://man.archlinux.org/man/socket.2
	   https://man.archlinux.org/man/ip.7
	   https://man.archlinux.org/man/ipv6.7
	*/
	
	int sock = socket(AF_INET, SOCK_STREAM, 0);
	
	if(sock == -1) {
		perror("socket"); // si une erreur est détectée, on crash en affichant l'erreur, l'argument "socket" indique quoi afficher avant l'erreur (contexte)
		exit(1); // on arrête l'application avec comme valeur de retour 1, 0 étant retourné en cas d'arrêt sans erreur
	}
	
	/* Une fois la socket créée, on doit choisir de l'utiliser comme client ou serveurr.
	
	   Pour l'utiliser en tant que serveur, Linux a besoin de savoir :
	   - sur quel port écouter les connexions (TCP comme UDP fonctionne avec des numéros de ports)
	   - sur quelle adresse on doit écouter. En effet, un ordinateur peut avoir plusieurs adresses
	     IP à la fois, on peut en mettre une par interface réseau (ce qu'un routeur fait) ou même
	     plusieurs adresses par interfaces. Par conséquent, on peut indiquer à notre socket de recevoir
	     les connexions sur une adresse particulière ou sur toutes les adresses (ce qu'on va faire dans cet exemple)
	     
	   En fournissant ces informations, on dit qu'on va "binder" la socket à une adresse et à un port.
	   On utilise pour cela la fonction bind. Cette fonction prend en argument :
	   - la socket à "binder"
	   - le couple adresse/port sur lequel "binder" la socket
	   - la taille en octet de la structure "couple" donné juste avant
	   
	   Attention : plusieurs sockets ne peuvent pas écouter sur un même couple adresse/port. C'est logique car si le système
	   reçoit une connexion sur une adresse et un numéro de port et que ce couple a plusieurs sockets qui lui sont bindés,
	   comment le système pourrait savoir à quelle socket transmettre la connexion ?
	   
	   Documentation de la fonction bind :
	   $ man 2 bind
	   https://man.archlinux.org/man/bind.2
	*/
	
	struct sockaddr_in socketSin; // structure représentant le couple adresse/port sur laquelle on bind
	socketSin.sin_family = AF_INET; // on indique le type d'adresse à la fonction bind
	socketSin.sin_port = htons(80); // on indique le numéro de port (pour l'exemple, 80) dans l'ordre réseau (utilisation de la fonction htons)
	socketSin.sin_addr.s_addr = INADDR_ANY; // on veut écouter sur toutes les adresses de la machine, on utilise donc la macro INADDR_ANY qui représente en réalité l'adresse 0.0.0.0
	
	int res = bind(sock, (struct sockaddr*) &socketSin, sizeof(socketSin));
	
	if(res == -1) {
		perror("bind");
		exit(1);
	}
	
	/* On active ensuite l'écoute sur la socket. On utilise la fonction listen qui va
	   prendre en argument :
	   - la socket dont on veut démarrer l'écoute
	   - la taille de la file d'attente de connexions à accepter 
	   
	   Documentation de la fonction listen :
	   $ man 2 listen
	   https://man.archlinux.org/man/listen.2
	*/
	   
	res = listen(sock, 1000);
	
	if(res == -1) {
		perror("listen");
		exit(1);
	}
	
	/* À partir de maintenant la socket reçoit les demandes de connexion mais elle ne les accepte pas encore.
	   On utilise la fonction "accept" pour accepter les connexions. Cette fonction bloque tant qu'aucune
	   connexion n'est reçue. Quand une connexion est reçue, la fonction termine en retournant une nouvelle
	   socket permettant de communiquer avec le client qui vient de se connecter. On peut rappeler "accept"
	   juste après pour recommencer à attendre une connexion.
	   
	   La fonction prend en argument :
	   - la socket sur laquelle on écoute les demandes de connexion
	   - un pointeur vers une structure "sockaddr" (couple adresse/port) correspondant à l'adresse du client
	     qui vient de se connecter
	   - un pointeur vers une variable contenant avant l'exécution de la fonction la taille de la structure et
	     qui contiendra après la fonction, le nombre d'octets écrits dans la structure (informations sur le client)
	     
	   Pour l'exemple, on n'a pas besoin de connaître l'adresse du client donc on met les 2 derniers arguments à NULL */
	   
	int clientSock = accept(sock, NULL, NULL);
	
	if(clientSock == -1) {
		perror("accept");
		exit(1);
	}
}
