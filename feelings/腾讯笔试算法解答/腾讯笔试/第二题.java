package 腾讯笔试;

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

            if (cnt == 2 && !(end <= start)) res[i] = false;
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