package pass;

public class lc647 {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int d = 0; d < n; d++){
            for (int i = 0; i + d < n; i++){
                int j = i + d;
                char a = s.charAt(i);
                char b = s.charAt(j);
                if (a == b){
                    if (i + 1 >= j - 1) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) ans++;
                }
                
            }
        }
        return ans;
    }
}
