package 腾讯笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 第三题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt(), m = in.nextInt();
        Tr tr = new Tr(n);
        Set<Integer> ori = new HashSet<>();
        while (m != 0) {
            int u = in.nextInt(), v = in.nextInt();
            tr.merge(u, v);
            m--;
        }

        for (int i = 1; i <= n; ++i) {
            ori.add(tr.find(i));
        }

        if (ori.size() > 2) {//连通分量大于2，新增一条边无法构成连通图
            System.out.println(0);
        } else if (ori.size() == 1) {
            System.out.println((long) n * (long) (n - 1) / 2);
        } else {//连通分量为2
            long sh = -1;
            for (Integer i : ori) {
                if (sh == -1) {
                    sh = tr.sz[tr.find(i)];
                } else {
                    System.out.println(sh * tr.sz[tr.find(i)]);
                }
            }
        }
    }

    public static class Tr {
        int n;
        int[] p;
        int[] sz;

        Tr(int n) {
            this.n = n;
            p = new int[n + 1];
            sz = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                p[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int u) {
            while (u != p[u]) u = p[u] = p[p[u]];
            return u;
        }

        public void merge(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                p[x] = y;
                sz[y] += sz[x];
            }
        }
    }
}
