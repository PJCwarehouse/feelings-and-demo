package 腾讯笔试第一套;

import java.util.Scanner;

/**
 * 5.小红的tencent矩阵
 * 小红拿到了一个字符矩阵，她可以从任意一个地方出发，希望走 6 步后恰好形成"tencent"字符串。小红想知道，共有多少种不同的行走方案？
 * 注：每一步可以选择上、下、左、右中任意一个方向进行行走。不可行走到矩阵外部。
 *
 * 输入描述
 * 第一行输入两个正整数n,m，代表矩阵的行数和列数。
 * 接下来的n行，每行输入一个长度为m的、仅由小写字母组成的字符串，代表小红拿到的矩阵
 */
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