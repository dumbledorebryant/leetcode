package pass;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int length = nums.length;
        if (length == 1) return false;
        if (sum % 2 != 0) return false;
        int cap = sum / 2;

        boolean[][] dp = new boolean[length + 1][cap + 1];
        for (int i = 0; i <= length; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            for (int j = 1; j <= cap; j++){
                if (j < num){
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[length][cap];
    }
}
