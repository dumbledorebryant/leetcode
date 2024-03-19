package pass.Company.Navan;

public class PathToAGoal {
    int mod = (int)1e9 + 7;
    public int solutions(String str, int n, int x, int y){
        char[] s = str.toCharArray();
        int[] prevSame = new int[s.length];
        int idxL = -1;
        int idxR = -1;
        for (int i = 0; i < prevSame.length; i++) {
            if (s[i] == 'l') {
                prevSame[i] = idxL;
                idxL = i;
            } else {
                prevSame[i] = idxR;
                idxR = i;
            }
        }

        // dp[i][j] is number of distinct subsequnces of length i to end up at j
        long[][] dp = new long[s.length+1][n+1];
        dp[0][x] = 1;
        for (int i = 1; i <= s.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if (s[i-1] == 'l') {
                    if (j+1 <= n) dp[i][j] += dp[i-1][j+1];
                    if (j+1 <= n && prevSame[i-1] >= 0) dp[i][j] -= dp[prevSame[i-1]][j+1];
                } else {
                    if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                    if (j-1 >= 0 && prevSame[i-1] >= 0) dp[i][j] -= dp[prevSame[i-1]][j-1];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[s.length][y];
    }
}
