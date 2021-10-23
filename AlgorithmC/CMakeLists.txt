cmake_minimum_required(VERSION 3.19)
project(AlgorithmC C)

set(CMAKE_C_STANDARD 11)

add_executable(AlgorithmC
        991.c
        chapter2.c
        chapter5.c
        chapter6.c
        donut.c
        find.c
        hello.c
        pointer.c
        str.c)
add_executable(foo hello.c)