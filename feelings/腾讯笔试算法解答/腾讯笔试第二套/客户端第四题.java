package 腾讯笔试第二套;

import java.util.*;
public class 客户端第四题 {
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
            int child_length = treeLength(record, child);
            // 删除当前分支，并计算根节点的直径
            children.remove(Integer.valueOf(child));
//这里没有record.put(child,children)，并没有对record数据造成修改，所以remove和add操作没意义
            int root_length = treeLength(record, 0);
            result = Math.min(result, Math.abs(child_length - root_length));

            //还原当前分支
            children.add(child);
            treeDiameter(record, child);
        }


    }
    static int maxLength = 0;
//treeLength到底是求深度还是直径
//如果是求深度，那么result不应该等于Math.abs(child_length - root_length)
//如果是求直径，那么max_deep不应该等于treeLength(record, child)，且最后返回值不应该是max_deep + 1
//这里的maxLength也没有被使用过
    //错误案例：应该返回1，结果返回0
//            7
//            0 1
//            1 2
//            0 3
//            3 4
//            4 5
//            5 6

//直径好像并不一定是深度第一大和深度第二大的和，如下所示：0的直径并不是0的两个分支深度差，这个题还要再思考一下

//    0 1
//    0 2
//    2 3
//    2 4
//    3 5
//    4 6
    public static int treeLength(Map<Integer, List<Integer>> record, int root) {
        List<Integer> children = record.get(root);
        if (children == null || children.isEmpty()) {
            return 0;
        }
        if (children.size() == 1) {
            int deep = 1 + treeLength(record, children.get(0));
            maxLength = Math.max(deep, maxLength);
            return deep;
        }
        // 深度第一大和深度第二大的和
        int max_deep = 0;
        List<Integer> deeps = new ArrayList<>();
        for (int child : children) {
            max_deep = Math.max(treeLength(record, child), max_deep);
            deeps.add(max_deep);
        }
        Collections.sort(deeps);
        maxLength = Math.max(deeps.get(deeps.size() - 1) + deeps.get(deeps.size() - 2), maxLength);
        return max_deep + 1;
    }


}
