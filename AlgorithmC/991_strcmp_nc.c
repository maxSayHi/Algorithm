#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000

/**
 * 字符串处理函数stremp（s1，s2）可以比较两个字符串的大小，其字符的大小是以ASCII码
表上的顺序决定。该函数首先将s1第一个字符值减去s2的第一个字符值，若差值为0则继
续比较对应的下一介字符，若不为0则该差值就是函数的最终结果。
请参照该函数的实现原理，
写个新的字符串比较函数strcmp_nc（s1，s2），该函数的功
能与stremp类似但不区分字符串中的大小写字母，例如，字符a和字符A相等。
要求：实现过程中不得使用任何已有的关于字符和字符串处理的库函数。
*/
int main(int argc, char *argv[]) {
    printf("%d\n",argc);
    printf("%d\n",sizeof(*argv));
    for(int i=0;i<argc-1;i++){
        printf("%s\n",argv[i]);
    }
    printf("%c\n",'A'+'a'-'A');
}

int strcmp_nc(char *src, char *dst) {
    int ret = 0;
    while(*src){
        if(*src >= 'A' || *src <= 'Z'){
            *src = *src + ('a' - 'A');
        }
        src++;
    }

    while(*dst){
        if(*dst >= 'A' || *dst <= 'Z'){
            *dst = *dst + ('a' - 'A');
        }
        dst++;
    }

    while(!(ret = *(unsigned char*)src - *(unsigned char*)dst) && *dst){
        ++src;++dst;
    }
    if(ret<0){
        return -1;
    } else if(ret>0){
        return 1;
    }else{
        return ret;
    }
}