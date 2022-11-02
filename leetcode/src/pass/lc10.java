package pass;

public class lc10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++){
            char cs = s.charAt(i - 1);
            for (int j = 1; j <= n; j++){
                char cp = p.charAt(j - 1);
                if (cs == cp || cp == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (cp == '*'){
                    char pre = p.charAt(j - 2);
                    if (pre == cs || pre == '.'){
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
