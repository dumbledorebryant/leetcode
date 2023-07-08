package pass;

public class lc198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] money = new int[length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 2; i <= length; i++){
            money[i] = Math.max(money[i - 2] + nums[i - 1], money[i - 1]);
        }
        return money[length];
    }

    public int rob2(int[] nums){
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= length; i++){
            int num = nums[i - 1];
            dp[i] = Math.max(num + dp[i - 2], dp[i - 1]);
        }
        return dp[length];
    }
}
