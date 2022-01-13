package pass;

public class lc516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++){
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--){
            for (int j = i + 1; j < length; j++){
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][length - 1];
    }
    public int dp(String s, int i, int j){
        if (i == j) return 1;
        if (i < j) return 0;
        char a = s.charAt(i);
        char b = s.charAt(j);
        if (a == b) return 2 + dp(s, i + 1, j - 1);
        else {
            return Math.max(dp(s, i + 1, j), dp(s, i, j - 1));
        }
    }
}
