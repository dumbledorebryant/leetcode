package pass;

import java.util.Arrays;

public class lc45 {
    int[] dp;
    public int jump(int[] nums) {
        int length = nums.length;
        dp = new int[length];
        Arrays.fill(dp, length);
        return dp(nums, 0);
    }
    
    public int dp(int[] nums, int index){
        int len = nums.length;
        if (index >= len - 1) return 0;

        if (dp[index] != len) return dp[index];

        int steps = nums[index];
        for (int i = 1; i <= steps; i++){
            int res = dp(nums, index + i);
            dp[index] = Math.min(dp[index], res + 1);
        }
        return dp[index];
    }
    public int jump2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i){
                end = farthest;
                ans++;
            }
        }
        return ans;
    }
}
