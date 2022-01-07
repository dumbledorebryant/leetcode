package pass;

import java.util.Arrays;

public class lc931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) dp[0][i] = matrix[0][i];
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n; j++){
                int num = matrix[i][j];
                if (j == 0) {
                    dp[i][j] = num + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
                else if (j == n - 1) {
                    dp[i][j] = num + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                else 
                    dp[i][j] = num + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
