package pass;

import java.lang.reflect.Array;
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
    public int coin(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins){
                if (i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }
}
