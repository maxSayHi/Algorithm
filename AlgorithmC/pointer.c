#include<stdio.h>

int main(int argc, char const *argv[])
{
  int a;
  int *p;
  a = 10;
  printf("%d\n",a);
  p = &a;
  *p=20;
  *p= *p+1;
  printf("%d\n",a);
  
  char *str = "我很开心，我很快乐！我喜欢黄铅笔！!!";
  printf("%s",str);

  return 0;
}