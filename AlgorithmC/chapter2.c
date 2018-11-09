#include<stdio.h>
#include<float.h>
#include<limits.h>
/**
Exercise 2-1. Write a program to determine the ranges of char , short , int , and long variables, both
signed and unsigned , by printing appropriate values from standard headers and by direct computation.
Harder if you compute them: determine the ranges of the various floating-point types.
 * */
void getRange(){
    printf("char范围%d\n",CHAR_MAX);
    printf("char范围%d\n",CHAR_MIN);
    printf("int范围%d\n",INT_MAX);
    printf("int范围%d\n",INT_MIN);
    printf("shrt范围%d\n",SHRT_MAX);
    printf("shrt范围%d\n",SHRT_MIN);
    printf("ushrt范围%d\n",USHRT_MAX);
    printf("long范围%d\n",LONG_MAX);
    printf("long范围%d\n",LONG_MIN);
    printf("float范围%d\n",FLT_MAX);
    printf("float范围%d\n",FLT_MIN);
    printf("double范围%d\n",DBL_MAX);
    printf("double范围%d\n",DBL_MIN);
    printf("size of %d\n",sizeof(long));
    printf("size of %d\n",sizeof(int));
    printf("size of %d\n",sizeof(double));
}
/*
Exercise 2-2. Write a loop equivalent to the for loop above without using && or || .
for (i=0; i < lim-1 && (c=getchar()) != '\n' && c != EOF; ++i)
s[i] = c;
for (i=0;; ++i){
    if(i>=lim-1){
        break;
    }
    if((c=getchar()) == '\n'){
        break;
    }
    if(c == EOF){
        break;
    }
    s[i] = c;
}

*/
void changeCode(){

}

void main(){
    // printf("hello world！\n");
    // print();
    getRange();
}
