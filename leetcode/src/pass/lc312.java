package pass;

public class lc312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] pts = new int[n + 2];
        pts[0] = 1;
        pts[n + 1] = 1;
        for (int i = 0; i < n; i++){
            pts[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--){
            for (int j = i + 1; j < n + 2; j++){
                for (int k = i + 1; k < j; k++){
                    dp[i][j] = Math.max(
                        dp[i][j], 
                        dp[i][k] + dp[k][j] + pts[i] * pts[k] * pts[j]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }
}
