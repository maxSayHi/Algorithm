#include<stdio.h>
#include<ctype.h>
#include<string.h>

#define MAX_WORD 100;

struct point{
    int x;
    int y;
};

struct rect{
    struct point a;
    struct point b;
};

struct key{
    char *word;
    int count;
} keytabs[]={"hello",0,"hi",0};


struct tnode{
    char *key;
    int count;
    struct tnode *left;
    struct tnode *right;
};

void main(int argc,char *argv[]){
    struct point dot={-1,2};
    printf("x is %d  y is %d",dot.x,dot.y);

    struct point a={1,1};
    struct point b={2,2};
    struct rect r={a,b};
    printf("reca (%d,%d)  recb(%d,%d)",r.a.x,r.a.y,r.b.x,r.b.y);

    struct tnode *left;
    struct tnode *right;
    struct tnode node={"root",0,left,right};
}


struct tnode *addTree(struct tnode *p,char *w){
    int cond=0;
    if(p==NULL){
        p=tmalloc();
        p->key=tmalloc();
        p->count++;
    }else if(cond=strcmp(w,p->key)==0){
        p->count++;
    }else if(cond<0){
        p->left=addTree(p->left,w);
    }else if(cond>0){
        p->right=addTree(p->right,w);
    }
    return p;
}

struct tnode *tmalloc(){
    return (struct tnode *)malloc(sizeof(struct tnode));
}