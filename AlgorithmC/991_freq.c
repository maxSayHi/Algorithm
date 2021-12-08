#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLINE 1000

/**
 * 请编写一C语言函数freqs，该函数用于计算某个长字符串（称为源字符串）中指定子
串（称为目标子串）出现的频率。该函数有两个参数，第一个参数为源字符串（source），第
二个参数为目标子串（destination）；函数返回目标子串在源字符串中出现的次数。若目标
子串没有出现在源字符串中，则函数返回O。例如：若源字符串为“abcdefgdefkdxef”，
目标子串为“def”，则函数返回2。
on
约定：函数中需要考虑字符重复出现的情形。例如，若源字符串为“aaaa”，目标子
串为“aa”，则目标子串在源字符串中出现的频率为3

*/
int main(int argc, char *argv[])
{
    char *ori = argv[1];
    char *des = argv[1];
    printf("输入参数：%s\n",argv[0]);
    printf("%d\n",strlen(argv[1]));
    // int count = 0;
    // for(int i=0;i<sizeof(ori)-1;i++){
    //     int temp =0;
    //     for(int j=0;j<sizeof(des)-1;j++){
    //         if(ori[i+j]!=des[j]){
    //             break;
    //         }
    //     }
    // }
}

int freq(char source[],char destination){
    int ns = strlen(source);
    int nd = strlen(destination);
    int i=0;
    int num =0;
    char str[100];
    while(i+nd<=ns){
        strncpy(str,source+i,nd);
        if(strcmp(destination,str)==0) num++;
        i++;
    }
    return num;
}