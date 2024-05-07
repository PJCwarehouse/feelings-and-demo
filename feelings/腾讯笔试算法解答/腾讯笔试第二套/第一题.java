package 腾讯笔试第二套;

import 腾讯笔试第一套.第二题;

/**
 * 小红拿到了一个链表，她准备删除所有值恰好等于k的节点。你能帮帮她吗?
 */
public class 第一题 {
    public static void main(String[] args) {
        第一题 solution = new 第一题();

        // 创建测试链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 调用两个 delete 函数
        ListNode result1 = solution.delete(node1, 3);
        ListNode result2 = solution.delete2(node1, 3);

        // 输出结果
        System.out.println("Result 1:");
        printList(result1);
        System.out.println("\nResult 2:");
        printList(result2);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode delete2(ListNode head,int k){
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == k){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public ListNode delete(ListNode head,int k) {
        while(head.val == k){
            head = head.next;
        }
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.next.val == k){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
