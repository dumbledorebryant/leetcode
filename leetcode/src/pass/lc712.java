package pass;

public class lc712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int sum = 0;
        for (int i = 0; i < m; i++) sum += s1.charAt(i);
        for (int i = 0; i < n; i++) sum += s2.charAt(i);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = s1.charAt(i - 1);
                char b = s2.charAt(j - 1);
                if (a == b) dp[i][j] = dp[i - 1][j - 1] + ((int)a);
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], 
                                    dp[i][j - 1]);
                }
            }
        }
        return sum - 2 * dp[m][n];
    }
    public int max(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
}
