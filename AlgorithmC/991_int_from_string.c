#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000

/**
 * 八、程序设计题（本题20分）
请编写一C语言程序，该程序首先读取用户通过键盘输入的一个字符串（该字符串由数
字字符和非数字字符组成），然后将其中连续的数字字符作为）个整数提取出来，保存到相
应的整数数组中，最后将这些整数按照从大到小的顺序依次输出。例如：若用户输入的字
·符串为“abc123de45f*#6？*789&”，则应该分别提取出123、45、6和789四个整数，然后
按照789、123、45、6的顺序依次输出它们（说明：不考虑负整数情况，负号“-”作为非
数字字符处理）。
要求：
（1）将数字字符串转换为整数时不得使用C语言提供的库函数，需编写函数“stoi”来实
现。
2°
（2）把整数数组按照从大到小的顺序输出的功能也封装成一个单独的函数“output'”，不
*/

void ifromString();
int stoi(char *str);
void output(int a[],int length);

void ifromString() {
    char str[50],numc[10];
    int i=0,j=0,k=0,num[100];
    while(str[i]){
        if(str[i]>='0'&&str[i]<='9'){
            numc[j++] = str[i];
        }else{
            if(str[i-1]>='0'&&str[i-1]<='9'){
                num[k++] = stoi(numc);
                memset(numc,0,10);
                j=0;
            }
        }
        i++;
    }
    if(num[0]){
        num[k++] = stoi(numc);
    }
    output(num,k);
}

int stoi(char *str) {
    int value = 0;
    int flag = 1;
    if(*str == '-'){
        flag = -1;
        str++;
    }else if(*str == '+'){
        str++;
    }
    if (*str <= '0' || *str > '9') {
        return 0;
    }
    while (*str >= '0' && *str <= '9') {
        value = value * 10 + *str - '0';
    }
    return value;
}

void output(int a[],int length){
    for(int i=0;i<length;i++){
        for(int j=i+1;j<length;j++){
            if(a[j]>a[i]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

int main(int argc, char *argv[]) {
    char *str = "12ABC6";
    ifromString(str);
}
