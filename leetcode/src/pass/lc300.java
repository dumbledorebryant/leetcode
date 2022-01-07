package pass;

import java.util.Arrays;

public class lc300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++){
            int num = nums[i];
            for (int j = 0; j < i; j++){
                if (num > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++){
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
