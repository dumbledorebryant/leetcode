package pass;

public class lc188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 0; i <= k; i++){
            dp[0][i][1] = -100001;
        }
        for (int i = 1; i <= n; i++){
            int num = prices[i - 1];
            for (int j = 1; j <= k; j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + num);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - num);
            }
        }
        return dp[n][k][0];
    }
}
