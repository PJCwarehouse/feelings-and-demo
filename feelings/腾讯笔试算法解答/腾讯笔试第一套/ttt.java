package 腾讯笔试第一套;

import java.util.Scanner;

public class ttt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        long[] a = new long[m + 1];
        long[] pre = new long[m + 1];
        long[][] dp = new long[m + 1][n + 1];
        for(int i = 1;i <= m;i++){
            a[i] = in.nextInt();
            pre[i] = pre[i - 1] ^ a[i];
            dp[i][1] = pre[i];
        }
        for(int i = 2;i <= m;i++){
            for(int k = 2;k <= n && k <= i;k++){
                for(int j = k-1;j < i;j++){
                    dp[i][k] = Math.max(dp[i][k],dp[j][k-1] + pre[j] ^ pre[i]);
                }
            }
        }
        System.out.println(dp[m][n]);

    }
}
