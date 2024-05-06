package 腾讯笔试;

import java.util.Scanner;

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
