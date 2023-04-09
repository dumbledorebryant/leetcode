package pass;

public class lc267 {
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;

        for (int i = 2; i <= n; i++){
            dp[i] = k * (dp[i - 2] + (k - 1) * dp[i - 1]); 
        }
        return dp[n];
    }
}