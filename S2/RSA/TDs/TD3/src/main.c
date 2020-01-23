//
// Created by Quentin Millardet on 2019-03-27.
//

int main() {
    int sockfd; // Socket d'écoute
    int tabclients[FD_SETSIZE] // Les sockets de dialogue
    struct sockaddr cli_addr;
    int i= 0; // nb client
    fdset rset;
    FD_ZERO(&rset);
    FD_SET(sockfd, @rset);


    for (;;){
        int nbfd = select(maxfdp, &rset, NULL, NULL, NULL);
        if (FD_ISSET(sockfd, &rset)){
            tabclients[i] = accept(sockfd, &cli_addr, &clilen);
            FD_SET(tabclients[i], &rset);
            i++;
        }
        for (int j=0; j<i; j++){
            if (FD_ISSET(tabclients[j], &rset)){
                //traiter le message reçu

            }
        }
    }

}

int 