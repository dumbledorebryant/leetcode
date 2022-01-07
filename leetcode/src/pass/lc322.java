package pass;

import java.util.Arrays;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int length = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < length; j++){
                if (i - coins[j] >= 0)
                    dp[i] = 1 + Math.min(dp[i - coins[j]], dp[i]);
            }
        }
        return dp[amount];
    }
}
