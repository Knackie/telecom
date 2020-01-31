cmake_minimum_required(VERSION 3.14)
project(Exercice_3 C)

set(CMAKE_C_STANDARD 11)

add_executable(ICMP src/icmpd-incomplet.c)
add_executable(ClientUDP src/clientUDP.c)
