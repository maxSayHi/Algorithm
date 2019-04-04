#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLINE 1000


int main(int argc, char *argv[])
{
    printf("%d\n",argc);
    while(argc>0){
        printf("%s\n",argv[--argc]);
    }
    // int a=4,b=2;
    // printf("%d\n",a|b);
    // printf("%d\n",a||b);
    // printf("%d\n",a>>b);
    // printf("%d\n",a/b);

    // int a[20]={0,1,2,3,4,5,6,7,8,9};
    // printf("%d\n",*(a+5));

    // putchar('a');
    // printf("%c",getchar());

    // char name[20];
    // scanf("%s",name);
    // printf("%s",name);

    // int age;
    // scanf("%d",&age);
    // printf("%d",age);


    FILE *names;
    if(NULL==(names=fopen("/home/max/names","r+"))){
        printf("file open failed");
    }else{
        printf("file opened\n");
        // char *content="abcdefg";
        // while(*content!='\0'){
        //     fputc(*content++,names);
        // }

        // char c;
        // while(EOF!=(c=fgetc(names))){
        //     printf("%c",c);
        // }
        fclose(names);
    }
}
