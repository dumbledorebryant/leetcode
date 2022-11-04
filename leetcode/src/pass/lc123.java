package pass;

public class lc123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];
        for (int i = 0; i <= 2; i++){
            dp[0][i][1] = -100001;
        }
        for (int i = 1; i <= n; i++){
            int num = prices[i - 1];
            for (int j = 1; j <= 2; j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + num);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - num);
            }
        }
        return dp[n][2][0];
    }
}
