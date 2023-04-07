package pass;

import java.util.Arrays;

public class lc132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--){
            char jch = s.charAt(i);
            for (int j = i + 1; j < n; j++){
                char ich = s.charAt(j);
                if (ich == jch){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else dp[i][j] = false;
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++){
            if (dp[0][i]){
                f[i] = 0;
            }
            else {
                for (int j = 0; j < i; j++){
                    if (dp[j + 1][i]){
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
