#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000

/**
 * 查找变位词
 * 
 * 请编写一个语言程序，用来求解某个单词在一篇文章中的变位词。用户通过键
盘输入一个单词和一个文本文件的名称，程序按照升序输出在这个文本文件中出现的
该单词的所有变位词（同一个变位词多次出现的，只输出一次）；如果没有变位词，则
程序输出NONE。
说明：（1）为了简化问题，假设所有涉及的单词长度均不超过20个字母，文本
文件中出现的都是普通单词，它们通过空格符、制表符或者回车进行分隔，没有数字、
标点符号等其他特殊符号，且单词个数不超过100个。
2变位词不这分大、
小写（大、小/写字母均被认为是相同的），即：Silent也是listen变位词。相同的单词不是变位词，C如Silent不是Silent f的变位词。为了简化问
题，可以考虑把所有输入的单词都转换为小写，排序输出时也不再考虑大、小写问题，
全部以小写形式输出。

关键点：
文件读取
大小写转换

网学天地的答案，就和SB一样，没有给出题目要求的文件操作。

*/
int main(int argc, char *argv[]) {
    char str[] = "ABCABC";
    char subStr[] = "A";
//    printf("%d\n", subCount(str, subStr));
     printf("%c\n",str);
}

int subCount(char *str, char *substr) {
    char *p, *q;
    int num = 0;
    while (*str != '\0') {
        for (p = str, q = substr; *p != '\0' && *q != '\0' && *p == *q; p++, q++);
        if (*q != '\0') {
            *str++;//这里为什么用*?
        } else {
            num++;
            str = p;
        }


        printf("%c\n", *p);
    }
    return num;
}