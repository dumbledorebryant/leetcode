package pass;

import java.util.HashSet;
import java.util.Set;

public class lc213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int res = dp[length - 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[1];
        for (int i = 3; i <= length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return Math.max(res, dp[length]);
    }
}
