package pass;

public class lc122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++){
            int num = prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - num);
            dp[i][1] = Math.max(dp[i - 1][0] + num, dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }
}
