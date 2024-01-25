# 链表

Cannot read field "next" because "<local2>" is null

原因:由于不存在next节点，有点像数组超出长度界限，一般存在于算法中让返回头结点但头结点为空或者头结点的指向为空
解决方法:
if(head == null || head.next == null){
            return head;
        }