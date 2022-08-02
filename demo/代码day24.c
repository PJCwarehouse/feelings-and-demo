node* In_reverseList(node* H)
{
	if (H == NULL || H->next == NULL)       //链表为空直接返回，而H->next为空是递归基
		return H;
	node* newHead = In_reverseList(H->next); //一直循环到链尾 
	H->next->next = H;                       //翻转链表的指向
	H->next = NULL;                          //记得赋值NULL，防止链表错乱
	return newHead;                          //新链表头永远指向的是原链表的链尾
}
