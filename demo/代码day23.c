#include <stdio.h>
#include <stdlib.h>

typedef struct lianbiao
{
    int date;
    struct lianbiao* pnext;
}link;
link* pnew;//新节点
link* phead;//头节点
link* ptemp;//临时节点
void creat(void);
void add(void);
int count = 0;
int main()
{
    int n, i;
    
    printf("请输入所需要创建的链表长度,不可为0\n");
    scanf_s("%d", &n);
    creat();
    int a[100];
    printf("请输入链表数据");
    for (i = 0; i < n-1; i++)
    {
        scanf_s("%d", &a[i]);
        count = a[i];
        add();
    }
    printf("链表创建完毕，输出链表所有数据\n");

    //printf("%d ", phead->date);
    for (ptemp = phead; ptemp != NULL; ptemp = ptemp->pnext)
    {
        printf("%d ", ptemp->date);
    }
    return 0;
}
void creat(void)//创建头节点
{
    phead = (link*)malloc(sizeof(link));
    phead->pnext = NULL;
    phead->date = 0;
    //memset(link,0,sizeof(link));
}
void add(void)//添加节点
{
    pnew = (link*)malloc(sizeof(link));
    pnew->date = count;
    pnew->pnext = 0;
    ptemp = phead;
    while (ptemp->pnext != NULL)
    {
        ptemp = ptemp->pnext;
    }
    ptemp->pnext = pnew;
    //pnew=NULL;
}