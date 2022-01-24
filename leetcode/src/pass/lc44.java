package pass;

public class lc44 {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        for (int i = 0; i <= slen; i++){
            dp[i][0] = false;
        }
        int m = 0;
        while (p.charAt(m) == '*' && m < plen){
            for (int i = 0; i <= slen; i++){
                dp[i][m + 1] = true;
            }
            m++;
        }
        dp[0][0] = true;
        for (int i = 1; i <= slen; i++){
            char sch = s.charAt(i - 1);
            for (int j = 1; j <= plen; j++){
                char pch = p.charAt(j - 1);
                if (sch == pch){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pch == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pch == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                }
                else dp[i][j] = false;
            }
        }
        return dp[slen][plen];
    }
}
