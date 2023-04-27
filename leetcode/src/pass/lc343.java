package pass;

public class lc343 {
    public int integerBreak(int n) {
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = i + 1; j <= n; j++){
                dp[j] = Math.max(dp[j], (j - i) * Math.max(i, dp[i]));
            }
        }
        return dp[n];
    }
}
