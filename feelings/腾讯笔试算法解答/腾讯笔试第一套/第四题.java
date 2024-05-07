package 腾讯笔试第一套;

import java.util.Scanner;

/**
 * 4.小红拿到了一个数组，她准备将数组分割成 k 段，使得每段内部做按位异或后，再全部求和。小红希望最终这个和尽可能大，你能帮帮她吗？
 *
 * 输入描述
 * 输入包含两行。
 * 第一行两个正整数 n, k , (1\leq k \leq n \leq 400)，分别表示数组的长度和要分的段数。
 * 第二行 n 个整数 a_i (0 \leq a_i \leq 10^9)，表示数组 a 的元素。
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 第四题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        long[] a = new long[m + 1];
        long[] pre = new long[m + 1];
        long[][] dp = new long[m + 1][n + 1];
        //f[i][j]的含义是i个数字时，分成j段
        for(int i = 1;i <= m;i++){
            a[i] = in.nextInt();
            pre[i] = pre[i - 1] ^ a[i];//pre[0]为默认值0，而任何数与0做异或都等于本身，所以pre[1] = a[1]
            //前缀异或pre[i]
            dp[i][1] = pre[i];
        }
        for(int k = 2;k <=n;k++){//分的段数
            for(int i = k;i <= m;i++){//数字个数
                for(int j = k-1;j < i;j++){//断点位置
                    dp[i][k] = Math.max(dp[i][k],dp[j][k-1] + pre[j] ^ pre[i]);//最后一段以j点为分界，断开时最大的异或和
                    //知识点：前缀异或pre[i] ⊕ pre[j] 等于序列第 i+1 到 j 个数字的异或和。
                }
            }
        }//先求同一段数的不同字数的最大值
//        for(int i = 2;i <= m;i++){
//            for(int k = 2;k <= n && k <= i;k++){
//                for(int j = k-1;j < i;j++){
//                    dp[i][k] = Math.max(dp[i][k],dp[j][k-1] + pre[j] ^ pre[i]);
//                }
//            }
//        }//先求同一数字的不同段数的最大值
        System.out.println(dp[m][n]);
    }
}
