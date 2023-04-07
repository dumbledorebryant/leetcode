package pass;

public class lc115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++){
            char sch = s.charAt(i - 1);
            for (int j = 1; j <= n; j++){
                char tch = t.charAt(j - 1);
                if (sch == tch){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
