package pass;

public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = -100000;
        for (int i = 1; i <= n; i++){
            int num = prices[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + num - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - num);
        }
        return dp[n][0];
    }
}
