package pass;

public class lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            if (num == 0){
                dp[i] = 0;
            }
            else dp[i] = dp[i - 1] + 1;
        }
        int ans = 0;
        for (int i = 0; i <= length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
