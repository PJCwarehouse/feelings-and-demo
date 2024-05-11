package 腾讯笔试第二套;

import java.util.*;
public class 第四题数组写法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> record = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            List<Integer> set_p = record.get(p);
            if (set_p == null) {
                set_p = new ArrayList<>();
            }
            set_p.add(q);
            record.put(p, set_p);
        }

        treeDiameter(record, 0);
        System.out.println(result);
    }

    /**
     * 0
     * 1 2 3
     * (4 5) (6 7) (8 9)
     */


    static int result = Integer.MAX_VALUE;

    public static void treeDiameter(Map<Integer, List<Integer>> record, int root) {
        List<Integer> children = record.get(root);
        if (children == null || children.isEmpty()) {
            return;
        }

        List<Integer> copy = new ArrayList<>(children);
        for (int child : copy) {
            // 孩子作为根节点的直径
            int child_length = treeLength(record, child)[1];
            // 删除当前分支，并计算根节点的直径
            children.remove(Integer.valueOf(child));
            record.put(root,children);
            //这里使用的引用传递
            int root_length = treeLength(record, 0)[1];
            result = Math.min(result, Math.abs(child_length - root_length));

            //还原当前分支
            children.add(child);
            record.put(root,children);
            treeDiameter(record, child);
        }


    }

    //返回深度和直径
    public static int[] treeLength(Map<Integer, List<Integer>> record, int root) {
        List<Integer> children = record.get(root);

        int max_deep = 0;
        int maxLength = 0;

        if (children == null || children.isEmpty()) {
            return new int[]{0,0};
        }
        if (children.size() == 1) {
            max_deep = treeLength(record, children.get(0))[0]+1;
            maxLength = Math.max(treeLength(record, children.get(0))[0],max_deep);
            return new int[]{max_deep,maxLength};
        }
        // 找出子树最大直径，以及排列子树深度
        List<Integer> deeps = new ArrayList<>();
        for (int child : children) {
            int[] childDeepAndLength = treeLength(record, child);
            max_deep = Math.max(childDeepAndLength[0], max_deep);
            maxLength = Math.max(childDeepAndLength[1], maxLength);
            deeps.add(childDeepAndLength[0]);
        }
        Collections.sort(deeps);
        //如果当前的最大深度和第二大深度的长度和大于当前最大子直径，那么就可以更新直径，否则还是使用原先的最大子直径
        maxLength = Math.max(deeps.get(deeps.size() - 1) + deeps.get(deeps.size() - 2) + 2, maxLength);
        return new int[]{max_deep + 1, maxLength};
    }


//    7
//            0 1
//            1 2
//            0 3
//            3 4
//            4 5
//            5 6
//答案：1
    //错误案例：应该返回1，结果返回0
//            7
//            0 1
//            1 2
//            0 3
//            3 4
//            4 5
//            5 6
//
//7
//    0 1
//    0 2
//    2 3
//    3 5
//    2 4
//    4 6
//    答案：3
}
