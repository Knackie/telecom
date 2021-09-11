#include <netinet/in.h>
#include <sys/select.h>
#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>

int main(void){
    int socketServer = socket(AF_INET,SOCK_STREAM,0);
    struct sockaddr_in addrServer;
    addrServer.sin_family = AF_INET;
    addrServer.sin_addr.s_addr = inet_addr("127.0.0.1");
    addrServer.sin_port = htons(9500);

    bind(socketServer,(const struct sockaddr *)&addrServer,sizeof(addrServer));
    
    listen(socketServer,SOMAXCONN);

    struct sockaddr_in addrClient;
    socklen_t csize = sizeof(addrClient);
    int socketClient;
    for(;;){
        if((socketClient = accept(socketServer, (struct sockaddr *)&addrClient, &csize))<0){
            perror("probleme accept");
            exit(1);
        }
        send(socketClient,"Bonjour",10,0);
        switch (fork())
        {
        case -1:
            perror("probleme fork");
            exit(1);
        case 0:
            close(socketServer);
            char buffer[1024];
            while(strcmp(buffer,"exit") != 0){
                int n = recv(socketClient,buffer,sizeof buffer - 1,0);
                buffer[n] = '\0';
                printf("%s\n",buffer);
            }
            close(socketClient);
            exit(0);
        default: close(socketClient);
        }
    }
    close(socketClient);
    close(socketServer);
    printf("close\n");
    return 0; 
}
