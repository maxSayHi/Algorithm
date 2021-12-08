#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLINE 1000

/*****
 * 输入年、月、日，输出变位词
*/
int main(int argc, char *argv[])
{
    long year, month, day;
    long totalday;
    int week;
    int monthday[12] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 331};
    int monthdayLeap[12] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 331};
    char *weekName[7] = {"Sunday", "Mon", "Tuse", "Wen", "Thurs", "Fri", "Sat"};
    printf("请输入年 月 日");
    scanf("%ld %ld %ld", &year, &month, &day);
    totalday = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        totalday += monthdayLeap[month - 1];
    else
        totalday += monthday[month - 1];
    totalday += day;
    week = totalday % 7;
    printf("%s", weekName[week]);
}