#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000
#define ABC(x,y) ((x-y)/(x+y))

/**
 * 多项式乘法。20年的真题，当时一点思路都没有，一塌糊涂....自己学了这么多链表的知识，居然想不起来用，要让知识动起来，不要静态思考，每天都呆呆的
*/
typedef struct Node *PolyNode;
struct Node{
    int left,right;
    PolyNode next;
};

//void multy(struct Node n1, struct Node n2);

int main(int argc, char *argv[]) {
    printf("hello!");
//    printf("%f",ABC(1.0+2.0,1.0+1.0));
}

void multy(PolyNode n1, PolyNode n2) {
    
}