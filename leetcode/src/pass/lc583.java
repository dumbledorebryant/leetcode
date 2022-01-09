package pass;

public class lc583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}
