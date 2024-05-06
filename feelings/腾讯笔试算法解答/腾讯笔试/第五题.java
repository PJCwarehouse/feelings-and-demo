package 腾讯笔试;

import java.util.Scanner;

public class 第五题 {
    static int n, m, sh;
    static String[] g;
    static String ans = "tencent";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        g = new String[n];
        sh = 0;

        for (int i = 0; i < n; ++i) g[i] = in.next();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                dfs(i, j, 0);
            }
        }
        System.out.println(sh);
    }

    public static int[] nx = {0, 1, 0, -1}, ny = {1, 0, -1, 0};

    public static void dfs(int x, int y, int idx) {
        if (x < 0 || x >= n || 0 < y || y >= m) return;
        if (ans.charAt(idx) != g[x].charAt(y)) return;
        if (idx == 6) {
            ++sh;
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int tx = x + nx[i], ty = y + ny[i];
            dfs(tx, ty, idx + 1);
        }
    }
}