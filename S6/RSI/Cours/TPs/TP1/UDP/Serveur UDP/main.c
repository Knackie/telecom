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
    int serverSocket, retread;
    char fromClient[MAXLINE];
    char fromUser[MAXLINE];
    struct sockaddr from;
    socklen_t fromlen;
    if ((serverSocket = socket(AF_INET, SOCK_DGRAM, 0)) <0) {
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
    int servlen = sizeof(serv_addr);
    if(0 > (retread = recvfrom(serverSocket, fromClient, MAXLINE, 0, (struct sockaddr *) &serv_addr, &servlen))){
        printf("Client :  %s", fromClient);
    }
    close(serverSocket);
    return 0;
}


int main() {
    serveurSocket();
    return 0;
}