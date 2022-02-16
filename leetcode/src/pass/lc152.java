package pass;

public class lc152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = nums[0];
        for (int i = 2; i <= length; i++){
            int num = nums[i - 1];
            int pre = nums[i - 2];
            int p = num * pre;
            int a = dp[i - 2];
            if (p > 0) dp[i] = p * Math.max(1, a);
            else {
                if (a > 1) dp[i] = p;
                else dp[i] = p * a;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i <= length; i++){
            ans = Math.max(nums[i - 1], Math.max(ans, dp[i]));
        }
        return ans;
    }
}
