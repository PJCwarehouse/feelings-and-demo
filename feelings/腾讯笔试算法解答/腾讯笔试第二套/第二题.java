package 腾讯笔试第二套;

/**
 * 小红拿到了一棵二叉树，每个节点的权值为0或1。
 *
 * 小红希望从一个节点出发，每次前往左儿子或者右儿子，直到走到叶子时停止，路径上所有节点将表示为一个二进制数（按路径顺序)。小红希望最终的二进制数在区间[l,r]内，请你告诉小红有多少种不同方案。
 */
public class 第二题 {
    int l;
    int r;
    int res;
    static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode left, ListNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void sum(ListNode node,int count){
        if(node == null) {
            if(count < r && count > l){
                res++ ;
            }
        }else {
            sum(node.left, count * 2 + node.val);
            sum(node.right, count * 2 + node.val);
        }
    }
    public void sum2(ListNode node,int count){
        if(node == null) return;
        count = count * 2 + node.val;
        if(node.left == null && node.right == null){
            if(count < r && count >l){
                res++ ;
            }
            return;
        }
        sum2(node.left,count);
        sum2(node.right,count);
    }
    public static void main(String[] args) {
        第二题 solution = new 第二题();

        // 创建测试二叉树
        ListNode leaf1 = new ListNode(0);
        ListNode leaf2 = new ListNode(1);
        ListNode leaf3 = new ListNode(0);
        ListNode leaf4 = new ListNode(1);

        ListNode node1 = new ListNode(0, leaf1, leaf2);
        ListNode node2 = new ListNode(1, leaf3, leaf4);
        ListNode root = new ListNode(1, node1, node2);

        // 设置区间范围
        solution.l = 2;
        solution.r = 8;

        // 计算方案数
        solution.res = 0;
        solution.sum2(root, 0);

        // 输出结果
        System.out.println("方案数：" + solution.res);

        solution.res = 0;
        solution.sum(root, 0);
        System.out.println("方案数：" + solution.res/2);

    }
}
