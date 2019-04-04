#include <stdio.h>
#include <string.h>
/**
 * Chapter 5 - Pointers and Arrays
*/
void swap(int *i, int *j);
void testPointer()
{
    int x = 1, y = 2, z[10];
    int *ip;
    ip = &x;
    x = y;

    z[2] = 6;
    ip = &z[2];
    // printf("%d\n",*ip);
    x = 0;
    y = 1;
    swap(&x, &y);

    int a[100];

    //char *s   （优先使用这种定义方式，这种用法，眼睛一看就知道是个指针）
    //完全等价
    //char s[]

    int n = 10;
    int *p;
    p + n; //如果int是4个字节，则n=4xn个字节
    printf("%d\n", x);
}

void main(int argc,char *argv[])
{
    char *target="hi i am bobo";
    char *article="ok,i know you,you don't need to say hi i am bobo";
    // printf("%s",strstr(article,target));
    while(--argc>0){
        // printf("%s\n",*++argv);
    }
    // printf("%d\n",argc);
    // testPointer();

    char *bobo="i am bobo";
    int arr[]={-1,1,2,3};
    int *ptr=arr;
    int a[]={1,2};
    int b[]={3,4};
    int *n[]={a,b};
    // int *n[]={{1,2},{3,4}};  这种方法不正确
    char *carray[]={"hello","today","is wensday"};
    // while(*bobo++){
    //     printf("%c\n",*bobo);
    // }
    // printf("%c\n",*(*((carray+1))+1));

    printf("%d\n",*n[1]);
    printf("%d\n",(*n)[1]);
}

void swap(int *i, int *j)
{
    int temp = *i;
    *i = *j;
    *j = temp;
}

void strspy(char *s, char *t)
{
    while (*s++ = *t++)
        ;
}

int strcmpme(char *s, char *t)
{
    for (; *s == *t; s++, t++)
    {
        if (*s == '\0')
            return 0;
    }
    return *s - *t;
}

void stack()
{
    int *p;
    *p++ = 1; //stack push
    *--p;     //stack pop
}

/**
 *精妙！！！！！！！！！
 太牛逼了 
 */
void month_day(int year, int yearday, int *pmonth, int *pday)
{
    char daytab[2][13] = {
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ,{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    int leap, i;
    leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    for (i = 1;yearday>daytab[leap][i];i++){
        yearday-=daytab[leap][i];
    }
    *pmonth=i;
    *pday=yearday;
}

int day_of_year(int year, int month, int day)
{
    char daytab[2][13] = {
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ,{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    int i,leap;
    leap=year%4==0&&year%100!=0||year%400==0;
    for(i=1;i<month;i++){
        day+=daytab[leap][i];
    }
}