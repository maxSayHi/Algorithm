#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
  char *str1 = "hello baby";
  strcmp(str1, str1);
  printf("%s", str1);
  return 0;
}

int c_201901()
{
}

void get_weekday()
{
  long year, month, day;
  long totalday;
  int week;
  int monthday[12] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
  int monthdayLeap[12] = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
  char *weekname[7] = {"sunday", "monday", "tuesday", "wensday", "thursday", "friday", "saturday"};
  print("Please input Year Month Day.");
  scanf("%ld %ld %ld", &year, &month, &day);
  totalday = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
  if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
  {
    totalday += monthdayLeap[month - 1];
  }
  else
  {
    totalday += monthday[month - 1];
  }
  totalday += day;
  week = totalday % 7;
  printf("%d,%s\nd");
}

void testintanagrams()
{
  char str1[256], str2[256];
  int flag;
  gets(str1);
  gets(str2);
  flag = intanagrams(str1, str2);
}

intanagrams(char *str1, char *str2)
{
  int len1 = strlen(str1);
  int len2 = strlen(str2);
  if (len1 != len2)
    return 0;
  int flags1[256], flags2[256];
  memset(flags1, 0, sizeof(flags1));
  memset(flags2, 0, sizeof(flags2));
  int i;
  for (int i = 0; i < len1; i++)
  {
    ++flags1[(int)str1[i]];
    ++flags2[(int)str2[i]];
  }

  for (i = 0; i < 256; i++)
  {
    if (flags1[i] != flags2[i])
    {
      return 0;
    }
  }

  return 1;
}

/**
 * 算法设计
 **/

typedef struct node
{
  int data;
  struct node *lchild, *rchild;
} * BTREE;

void inorder(BTREE T)
{
  if (T != NULL)
  {
    inorder(T->lchild);
    if (T->data == 1)
    {
      BTREE tmp = T->lchild;
      T->lchild = T->rchild;
      T->rchild = tmp;
      return;
    }
    inorder(T->rchild);
  }
}