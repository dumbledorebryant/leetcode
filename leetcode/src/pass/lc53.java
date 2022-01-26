package pass;

public class lc53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + num;
            else dp[i] = num;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
