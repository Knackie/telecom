#include <netinet/in.h>
#include <sys/select.h>
#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>

#define PORT 9500

int main() {
    int socketClient = socket(AF_INET,SOCK_STREAM,0);
    struct sockaddr_in addrClient;
    addrClient.sin_family = AF_INET;
    addrClient.sin_addr.s_addr = inet_addr("127.0.0.1");
    addrClient.sin_port = htons(PORT);
    connect(socketClient, (struct sockaddr*)&addrClient, sizeof(addrClient));
    char buffer[80];
    recv(socketClient,buffer,sizeof buffer -1,0);
    printf("%s\n",buffer);
    while (strcmp(buffer,"exit") != 0){
        scanf("%s", buffer);
        send(socketClient,buffer,sizeof(buffer),0);
    } 
    return 0;
}