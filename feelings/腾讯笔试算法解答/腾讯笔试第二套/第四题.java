package 腾讯笔试第二套;
import java.util.*;

public class 第四题 {
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
//            record.put(root, children);
            int root_length = treeLength(record, 0);
            result = Math.min(result, Math.abs(child_length - root_length));

            //还原当前分支
            children.add(child);
            treeDiameter(record, child);
        }


    }

    static int maxLength = 0;

    //返回root节点的直径
    public static int treeLength(Map<Integer, List<Integer>> record, int root) {
        int[] deeps = treeDeep(record, root);
        return deeps[0] + deeps[1];
    }

    //求root节点的第一树高和第二树高
    public static int[] treeDeep(Map<Integer, List<Integer>> record, int root){
        List<Integer> children = record.get(root);

        if (children == null || children.isEmpty()) {
            return new int[]{1,0};
        }
        if (children.size() == 1) {
            return new int[]{1 + treeDeep(record, children.get(0))[0],0};
        }
        List<Integer> deeps = new ArrayList<>();
        for (int child : children) {
            deeps.add(treeDeep(record, child)[0]);
        }
        Collections.sort(deeps);
        return  new int[]{deeps.get(0) + 1,deeps.get(1) + 1};
    }

}