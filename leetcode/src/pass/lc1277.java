package pass;

import java.util.*;;

public class lc1277 {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int num = matrix[i - 1][j - 1];
                if (num != 0){
                    int value = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j  - 1])) + 1;
                    dp[i][j] = value;
                    ans += value;
                }
            }
        }
        return ans;
    }
}
