package 腾讯笔试第二套;

public class 第五题dp写法 { /**
 * 有一个大小为n × m的地图，地图上每个格子都是红色或紫色的，每个格子都有一个价值为aj的宝藏，小红只能挖红色格子上的宝藏，小紫只能挖紫色格子上的宝藏。
 * <p>
 * 小红和小紫初始在地图左上角，她们只能同时向下或向右走，她们挖宝有以下限制: 1.有的格子可以跳过不挖。2.对于同一个人，不能连续挖两个相邻的格子。
 * <p>
 * 她们想知道走到地图右下角—共能获得的宝藏的最大价值和是多少。
 * <p>
 * 输入描述第—行输入两个整数n, m() . 接下来n行，每行输入m个整数agq(1≤aj ≤109)表示地图上每个点的价值。接下来n行，每行输入一个长度为'm的只由'R'和'P'组成的字符串表示地图每个格子的颜色，'R'代表格子为红色，'P'代表格子为紫色
 * 1<=n,m<=1e3
 */
public static void main(String[] args) {
    int value[][] = new int[][]{{2, 1, 1, 1}, {3, 2, 1, 1}, {3, 3, 3, 2}, {1, 2, 3, 3}};
    char[][] color = new char[][]{{'P', 'R', 'R', 'R'}, {'R', 'P', 'R', 'R'}, {'P', 'R', 'P', 'R'}, {'R', 'P', 'R', 'P'}};
    System.out.println(maxValues2(value,color));
//    System.out.println(maxValue(value, color, 0, 0, ' '));
}

    public static int maxValues2(int[][] value, char[][] color) {
        int m = color.length;
        int n = color[0].length;
        int[][][] dp = new int[m][n][2];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0){
                    dp[0][0][0] = 0;
                    dp[0][0][1] = value[0][0];
                    continue;
                }
                if(i == 0){
                    if(color[i][j] == color[i][j-1]){
                        dp[i][j][1] = dp[i][j-1][0] + value[i][j];
                    }else {
                        dp[i][j][1] = Math.max(dp[i][j-1][0] + value[i][j],dp[i][j-1][1] + value[i][j]);
                    }
                    dp[i][j][0] = Math.max(dp[i][j-1][0],dp[i][j-1][1]);
                } else if(j == 0){
                    if(color[i-1][j] == color[i][j]){
                        dp[i][j][1] = dp[i-1][j][0] + value[i][j];
                    }else {
                        dp[i][j][1] = Math.max(dp[i-1][j][0] + value[i][j],dp[i-1][j][1] + value[i][j]);
                    }
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]);
                }else{
                    if(color[i][j] == color[i-1][j] && color[i][j] == color[i][j-1]){
                        //当前位置与前面都冲突，那么如果拿的话，前一个只能不拿
                        dp[i][j][1] = Math.max(dp[i-1][j][0] + value[i][j],dp[i][j-1][0] + value[i][j]);
                        //当前位置不拿的话，前一个可拿可不拿
                        dp[i][j][0] = Math.max(Math.max(dp[i-1][j][1], dp[i][j-1][1]), Math.max(dp[i-1][j][0],dp[i][j-1][0]));
                    }else if(color[i][j] == color[i-1][j]){
                        //与其中之一冲突，如果当前取，有三种可能（冲突方向只能不拿，非冲突方向，可拿可不拿
                        dp[i][j][1] = Math.max(dp[i-1][j][0] + value[i][j], Math.max(dp[i][j-1][1] + value[i][j],dp[i][j-1][0] + value[i][j]));
                        //如果当前不取，冲突方向和非冲突方向 都是可拿可不拿
                        dp[i][j][0] = Math.max(Math.max(dp[i-1][j][1],dp[i-1][j][0]), Math.max(dp[i][j-1][1],dp[i][j-1][0]));
                    }else if(color[i][j] == color[i][j-1]){
                        dp[i][j][1] = Math.max(dp[i][j-1][0] + value[i][j], Math.max(dp[i-1][j][1] + value[i][j],dp[i-1][j][0] + value[i][j]));
                        dp[i][j][0] = Math.max(Math.max(dp[i-1][j][1],dp[i-1][j][0]), Math.max(dp[i][j-1][1],dp[i][j-1][0]));
                    }else {
                        //与两边都不冲突
                        dp[i][j][0] = Math.max(Math.max(dp[i-1][j][1],dp[i-1][j][0]), Math.max(dp[i][j-1][1],dp[i][j-1][0]));
                        dp[i][j][1] = dp[i][j][0] + value[i][j];
                    }
                }
            }
        }
        return Math.max(dp[m-1][n-1][1],dp[m-1][n-1][0]);
    }

    public static int maxValues(int[][] value, char[][] color){
        int m = color.length;
        int n = color[0].length;
        //dp含义：选择当前点的最大值
        int[][] dp = new int[m + 1][n + 1];
        //要么是左边来的，要么是上边来的
        dp[1][1] = value[0][0];
        for(int i = 1;i <= m;i++){
            for(int j = 2;j <= n;j++){
                if(i == 1){
                    if(color[i-1][j-1] == color[i-1][j-2]){
                        dp[i][j] = dp[i][j - 2] + value[i-1][j-1];
                    }else {
                        dp[i][j] = dp[i][j - 1] + value[i-1][j-1];
                    }
                }else if(j == 1){
                    if(color[i-1][j-1] == color[i-2][j-1]){
                        dp[i][j] = dp[i - 2][j] + value[i-1][j-1];
                    }else {
                        dp[i][j] = dp[i - 1][j] + value[i-1][j-1];
                    }
                }else {
                    int pre1 = 0;
                    int pre2 = 0;
                    if(color[i-1][j-1] == color[i-1][j-2]){
                        pre1 = Math.max(dp[i-1][j-1] + value[i-1][j-1], dp[i][j-2] + value[i-1][j-1]);
                    }else {
                        pre1 = dp[i][j-1] + value[i-1][j-1];
                    }
                    if(color[i-1][j-1] == color[i-2][j-1]){
                        pre2 = Math.max(dp[i-1][j-1] + value[i-1][j-1], dp[i-2][j] + value[i-1][j-1]);
                    }else {
                        pre2 = dp[i][j-1] + value[i-1][j-1];
                    }
                    dp[i][j] = Math.max(pre1,pre2);
                }
            }
        }
        return dp[m][n];
    }
    // from 0 代表上个位置没拿 ，1 代表拿了 R ，2 代表拿了 P
    public static int maxValue(int[][] value, char[][] color, int i, int j, Character from) {
        int n = value.length;
        int m = value[0].length;
        if (i >= n || j >= m) {
            return 0;
        }
        // 不拿
        int max_0 = Math.max(maxValue(value, color, i + 1, j, ' '), maxValue(value, color, i, j + 1, ' '));
        // 拿
        int max_1 = 0;
        if (from == ' ' || from != color[i][j]) { // 前一个不拿，或者当前和前一个不一样，都可以选择拿
            max_1 = value[i][j] + Math.max(maxValue(value, color, i + 1, j, color[i][j]), maxValue(value, color, i, j + 1, color[i][j]));
        }
        return Math.max(max_0, max_1);
    }
}
