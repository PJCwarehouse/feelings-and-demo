package 腾讯笔试第一套;

import java.util.Scanner;
/**
 * 1.小红拿到了一个无向图，其中一些边被染成了红色。
 * 小红定义一个点是“好点”，当且仅当这个点的所有邻边都是红边。
 * 现在请你求出这个无向图“好点”的数量。
 * 注：如果一个节点没有任何邻边，那么它也是好点。
 *
 * 输入描述
 * 第一行输入两个正整数n,m，代表节点的数量和边的数量。
 * 接下来的m行，每行输入两个正整数u,v和一个字符chr，代表节点u和节点v有一条边连接。如果 chr 为'R'，代表这条边被染红；'W'代表未被染色。
 */
public class 第一题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        boolean[] bool = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            bool[i] = true;
        }

        while (m != 0) {
            int u = in.nextInt(), v = in.nextInt();
            String s = in.next();
            if (s.equals("W")) {
                bool[u] = bool[v] = false;
            }
            m--;
        }
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if(bool[i]){
                res++;
            }
        }
        System.out.println(res);
    }
}
