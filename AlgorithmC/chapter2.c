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

/**
 * Exercise 2-4. Write an alternative version of squeeze(s1,s2) that deletes each character in s1 that
matches any character in the string s2 .
 */
void squeeze(){

}

/**
 * Exercise 2-3. Write a function htoi(s) , which converts a string of hexadecimal digits (including an
optional 0x or 0X ) into its equivalent integer value. The allowable digits are 0 through 9 , a through f ,
and A through F */
void htoi(char s[]){
    
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
