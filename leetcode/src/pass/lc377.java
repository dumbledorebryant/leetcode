package pass;

public class lc377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        int n = nums.length;
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < n; j++){
                int num = nums[j];
                if (i - num >= 0){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
