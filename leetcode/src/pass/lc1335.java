package pass;

public class lc1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        int[][] dp = new int[d + 1][length + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= length; j++){
            int minnum = 0;
            for (int m = 0; m <= j - 1; m++){
                minnum = Math.max(minnum, jobDifficulty[m]);
            }
            dp[1][j] = minnum;
        }
        dp[0][1] = 0;
        for (int i = 2; i <= d; i++){
            for (int j = 2; j <= length; j++){
                int jd = jobDifficulty[j - 1];
                int prejd = jobDifficulty[j - 2];
                if (jd <= prejd){
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + jd, dp[i][j - 1]);
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + jd, dp[i][j - 1] + jd - prejd);
                }
                
            }
        }
        return dp[d][length];
    }
}
