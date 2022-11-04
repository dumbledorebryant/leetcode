package pass;

public class lc309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = -1001;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++){
            int num = prices[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - num);
        }
        return dp[n][0];
    }
}
