package 腾讯笔试第二套;

import java.util.*;

public class 第三题 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        helper(1, 0, a, g);
        System.out.println(ans);
    }

    static int[] helper(int i, int f, int[] a, Map<Integer, List<Integer>> g) {
        List<int[]> arr = new ArrayList<>();
        int[] sum = new int[2];
        for (int nxt : g.get(i)) {
            if (nxt == f) continue;
            int[] v = helper(nxt, i, a, g);
            for (int j = 0; j < 2; ++j) sum[j] += v[j];
            arr.add(v);
        }
        if (a[i] == 2) {
            ans += sum[0];
            return new int[]{0, 1};
        }
        ans += sum[1];
        int sum_0 = sum[0];
        for (int j = 0; j < arr.size() - 1; ++j) {
            sum[0] -= arr.get(j)[0];
            ans += arr.get(j)[0] * sum[0];
        }
        return new int[]{1, sum_0};
    }
}
