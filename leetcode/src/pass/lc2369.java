package pass;

public class lc2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 2; i <= n; i++){
            if (nums[i - 1] == nums[i - 2]){
                if (i >= 3 && nums[i - 1] == nums[i - 3]) dp[i] = dp[i] || dp[i - 3];
                dp[i] = dp[i] || dp[i - 2];
            }
            else {
                if (nums[i - 1] == nums[i - 2] + 1){
                    if (i >= 3 && nums[i - 2] == nums[i - 3] + 1){
                        dp[i] = dp[i - 3];
                    }
                }
            }
            System.out.println("i: " + i + " res: " + dp[i]);
        }
        return dp[n];
    }
}
