package 腾讯笔试第一套;

/**
 * 2.小红拿到了一个链表。她准备将这个链表断裂成两个链表，再拼接到一起，使得链表从头节点到尾部升序。你能帮小红判断能否达成目的吗？
 * 给定的为一个链表数组，你需要对于数组中每个链表进行一次“是”或者“否”的答案回答，并返回布尔数组。
 * 每个链表的长度不小于 2，且每个链表中不包含两个相等的元素。所有链表的长度之和保证不超过10^5
 */
public class 第二题 {
    public boolean[] canSorted(ListNode[] lists) {
        int n = lists.length;
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; ++i) {
            res[i] = true;
            ListNode head = lists[i];
            int cnt = 1, start = head.val, pre = head.val, end = -1;
            head = head.next;
            while (head != null) {
                if (cnt == 1) {
                    if (pre <= head.val) {
                        pre = head.val;
                    } else {
                        cnt++;
                        end = head.val;
                    }
                } else {
                    if (end <= head.val) {
                        end = head.val;
                    } else {
                        res[i] = false;
                        break;
                    }
                }
                head = head.next;
            }

            if (cnt == 2 && end > start) res[i] = false;
        }
        return res;
    }
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}