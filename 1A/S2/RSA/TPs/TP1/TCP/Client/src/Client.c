//
// Created by Quentin Millardet on 2019-04-05.
//

#include <stdlib.h>
#include <stdio.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <arpa/inet.h>

#define SERV_PORT 2222

int lancerClient();

int lancerClient(){
    int MAXLINE = 20;
    int serverSocket, clientSocket;
    struct sockaddr_in serv_addr;
    char fromServeur[MAXLINE];
    char fromUser[MAXLINE];
    int n, retread;
    int client;
    struct hostent *hp;

    if ((clientSocket = socket(AF_INET, SOCK_STREAM, 0)) <0) {
        perror("erreur socket");
        exit(1);
    }
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(SERV_PORT);
    hp = (struct hostlen * )gethostbyname("127.0.0.1");
    serv_addr.sin_family = hp -> h_addrtype;
    serv_addr.sin_addr = *((struct in_addr *)(hp->h_addr));
    printf("IP adress : %s\n" , inet_ntoa(serv_addr.sin_addr));

    if (client = connect (clientSocket, (struct sockaddr *) &serv_addr, sizeof(serv_addr) ) < 0) {
        perror("cliecho : erreur connect");
        exit(1);
    }
    if ((n = recv(clientSocket, fromServeur, MAXLINE, 0))> 0) {
        printf("Serveur : %s", fromServeur);
        printf("Vous : ");
        if (fgets(fromUser, MAXLINE, stdin) == NULL){
            perror("error : fgets");
            exit(1);
        }
        if (n=send(clientSocket, fromUser, strlen(fromUser), 0) != strlen(fromUser)){
            printf("erreur writen");
            exit(1);
        }
    }
    while((retread = recv(clientSocket, fromServeur, MAXLINE, 0)) > 0){
        printf("Serveur : %s", fromServeur);
        if (strcmp(fromServeur, "Au revoir\n") == 0){
            break;
        }
        printf("vous : ");
        if (fgets(fromUser, MAXLINE, stdin) == NULL){
            perror("error : fgets");
            exit(1);
        }
        if (n=send(clientSocket, fromUser, strlen(fromUser), 0) != strlen(fromUser)){
            printf("erreur writen");
            exit(1);
        }
    }


}


int main(){
    lancerClient();
}