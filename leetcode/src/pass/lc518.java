package pass;

public class lc518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int j = 0; j < n; j++){
            for (int i = 1; i <= amount; i++){
                int coin = coins[j];
                if (i - coin >= 0)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
