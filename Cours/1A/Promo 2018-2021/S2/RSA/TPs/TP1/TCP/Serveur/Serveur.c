#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <zconf.h>

#define SERV_PORT 2222

struct sockaddr_in serv_addr;
int MAXLINE = 20;

int serveurSocket();

int serveurSocket(){
    int serverSocket, clientSocket;
    int dialogSocket;
    int clilen;
    struct sockaddr_in cli_addr;
    char fromClient[MAXLINE];
    char fromUser[MAXLINE];
    int n, retread;

    if ((serverSocket = socket(AF_INET, SOCK_STREAM, 0)) <0) {
        perror("erreur socket");
        exit(1);
    }
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(SERV_PORT);
    if(bind(serverSocket, (struct socketaddr *)&serv_addr, sizeof(serv_addr)) < 0){
        perror("servecho : erreur bind\n");
        exit(1);
    }
    if (listen(serverSocket, SOMAXCONN) <0) {
        perror ("servecho: erreur listen\n");
        exit (1);
    }
    clilen = sizeof(cli_addr);
    dialogSocket = accept(serverSocket, (struct sockaddr *)&cli_addr, (socklen_t *)&clilen);
    if (dialogSocket < 0) {
        perror("servecho : erreur accep\n");
        exit(1);
    }
    if (n = send(dialogSocket, "Bonjour \n", strlen("Bonjour \n"), 0) != strlen("Bonjour \n")){
        printf("erreur writer");
        exit(1);
    }
    while((retread = recv(dialogSocket, fromClient, MAXLINE, 0)) > 0){
        printf("Client :  %s", fromClient);
        if (strcmp(fromClient, "Au revoir\n") == 0){
            break;
        }
        printf("vous : ");
        if (fgets(fromUser, MAXLINE, stdin) == NULL){
            perror("error : fgets");
            exit(1);
        }
        if (n=send(dialogSocket, fromUser, strlen(fromUser), 0) != strlen(fromUser)){
            printf("erreur writen");
            exit(1);
        }
    }
    close(dialogSocket);
    return 0;
}


int main() {
   serveurSocket();
    return 0;
}