cmake_minimum_required(VERSION 3.19)
project(AlgorithmC C)

set(CMAKE_C_STANDARD 11)

add_executable(AlgorithmC
        991_poly_.c
        991_poly.c
        991_strcmp_nc.c
        991_int_from_string.c
        991_substr_count.c
        991.c
        chapter2.c
        chapter5.c
        chapter6.c
        donut.c
        find.c
        hello.c
        pointer.c
        str.c)
add_executable(foo 991_poly_.c)