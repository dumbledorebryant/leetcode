package pass;

import java.util.Arrays;

public class lc1312 {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = 0;
        }
        for (int i = len - 2; i >= 0; i--){
            for (int j = i + 1; j < len; j++){
                char a = s.charAt(i);
                char b = s.charAt(j);
                if (a == b) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
