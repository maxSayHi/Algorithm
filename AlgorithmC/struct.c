#include<stdio.h>

struct Circle{
  char name[50];
  int radius;
  struct Point{
    int x;
    int y;
  } pt;
};

int main(int args,char const *argv[]){
  struct Circle c,*pt = &c;
  pt->radius = 5;
}