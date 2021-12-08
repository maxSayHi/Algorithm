#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000

/**
 * 多项式乘法。20年的真题，当时一点思路都没有，一塌糊涂....自己学了这么多链表的知识，居然想不起来用，要让知识动起来，不要静态思考，每天都呆呆的
*/

typedef struct Node *PolyNode;
struct Node {
    int left;//系数
    int right;//次数
    PolyNode next;
};

void multy(PolyNode n1, PolyNode n2);

int main(int argc, char *argv[]) {
    PolyNode node1_0 = malloc(sizeof(PolyNode));
    node1_0->left = 2;
    node1_0->right = 1;
    PolyNode node1_1 = malloc(sizeof(PolyNode));
    node1_1->left = 3;
    node1_1->right = 2;
    node1_0->next = node1_1;

    PolyNode node2_0 = malloc(sizeof(PolyNode));
    node2_0->left = 1;
    node2_0->right = 1;
    multy(node1_0, node2_0);
}

void multy(PolyNode n1, PolyNode n2) {
    PolyNode dummyHead = malloc(sizeof(PolyNode));
    dummyHead->left = -1;
    dummyHead->right = -1;
    PolyNode head = dummyHead;
    PolyNode n2Head = n2;
    while (n1) {
        n2 = n2Head;
        while (n2) {
            int left = n1->left * n2->left;
            int right = n1->right + n2->right;
            dummyHead->next = malloc(sizeof(PolyNode));
            dummyHead->next->left = left;
            dummyHead->next->right = right;
            dummyHead = dummyHead->next;
            n2 = n2->next;
        }
        n1 = n1->next;
    }
    while (head != NULL) {
        printf("%d %d\n", head->left, head->right);
        head = head->next;
    }
}