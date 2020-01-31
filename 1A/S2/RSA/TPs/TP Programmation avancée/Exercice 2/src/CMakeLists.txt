cmake_minimum_required(VERSION 3.14)
project(src C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(src
        servmulti_tcp.c)
