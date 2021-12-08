#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLINE 1000

/*****
 * FASTQ文件是一种存储生物序列（通常称为核酸序列）以及相应质量评价的文本格式
文件。整个文件包含多条生物序列，每条生物序列由四行信息组成：第1行为序列标识，
以'@'开头；第2行是具体的生物序列（即由A、T、G、C组成的核酸序列）；第3行以'+'
开头，后面是序列的描述信息；第4行是质量信息，与第2行的序列一一对应，每个序
列均有一个质量评分，采用字符表示，该字符的ASCII码值即为质量值，取值为33到
126的ASCII码（即从字符'！到字符'～）。下面给出的是单条生物序列的一个示例（整个文
件就是由多个这样的生物序列依次存放组成的）。
@SEQ_ID
GATTTGGGGTTCAAAGCAGTATCGATCAAATAGTAAATCCATTTGTTCAACTCACAGTTT
+Description
（**+）%+）（%%）.1**-*）*55CCF>>C（
请根据上面的描述，编写一C语言程序，检查某个文件是否是合法的FASTQ文件。
该程序接收一个文件名参数，输出为检查结论
提示：
（1）检查规则：以每四行为一个处理单元，在这四行中，第1行以'@'开头；第2
行的序列只包含A、T、G、C四种核酸（表示核酸的四个字符大小写均可，即小写a、t、
g、c也是合法字符，并假定序列长度不超过2000）；第3行以'+'开头；第4行的长度与
第2行相同，并且为合法的质量取值。建议分别将每个检查规则编写成独立的函数。
（2）采用命令行参数的形式接收文件名参数。
（3）为了简化处理逻辑，当检查到文件中有1处格式不合法后，程序即可终止，输
出文件格式不合法的提示。只有当文件中所有的内容都合法，程序才输出文件格式合法
的提示。

*/

int atgc(char c)
{
    int i = 0;
    char str[] = "ATGCatgc";
    while (str[i] != '\0')
    {
        if (c == str[i])
            return 1;
        i++;
    }
    return 0;
}

int del(char str[])
{
    int n = strlen(str);
    if (str[n - 1] == '\n')
        str[n - 1] = '\0';
}

int first(char first[])
{
    return first[0] == '@';
}

int secon(char second[])
{
    int i = 0, n;
    if (strlen(second) > 2000)
        return 0;
    while (second[i] != '\0')
    {
        if (!atgc(second[i]))
            return 0;
        i++;
    }
    return 1;
}

int third(char third[])
{
    return third[0] == '+';
}

int fourth(char fourth[], char second[])
{
    if (strlen(fourth) != strlen(second))
        return 0;
    int i = 0;
    while (fourth[i] != '\0')
    {
        if (fourth[i] < 33 || fourth[i] > 126)
            return 0;
        i++;
    }
    return 1;
}

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        printf("error");
        exit(0);
    }
    FILE *fp;
    int i, j = 1, t;
    char s[4][2002];
    fp = fopen(argv[1], "r");
    if (fp == NULL)
    {
        printf("cannot open file");
        exit(0);
    }
    while (1)
    {
        i = 0;
        while (i < 4)
        {
            t = fgets(s[i], 2001, fp);
            del(s[i]);

            if (t == 0 && j == 1 && i == 0)
            {
                fclose(fp);
                printf("文件为空");
            }
            else if (t == 0 && i != 0)
            {
                fclose(fp);
                printf("不合法");
                return 0;
            }
            else if (t == 0 && j != 1 && i == 0)//读到文件末尾了
            {
                fclose(fp);
                printf("合法");
                return 0;
            }
            i++;
        }

        if (!first(s[0]))
        {
            fclose(fp);
            fprint("不合法");
        }
        if (!first(s[1]))
        {
            fclose(fp);
            fprint("不合法");
        }
        if (!first(s[2]))
        {
            fclose(fp);
            fprint("不合法");
        }
        if (!fourth(s[3], s[1]))
        {
            fclose(fp);
            printf("不合法！");
            return 0;
        }
        j++;
    }
}