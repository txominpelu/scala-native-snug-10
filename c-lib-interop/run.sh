#!/usr/bin/env bash

# compile library
clang -c src/main/resources/mystupidlib.c -o ./target/mystupidlib.o
# create static library
ar rcs ./target/libmystupidlib.a ./target/mystupidlib.o
# run with sbt
sbt run


