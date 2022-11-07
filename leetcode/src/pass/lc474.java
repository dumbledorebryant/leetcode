package pass;

import java.util.Arrays;

public class lc474 {
    public int findMaxForm(String[] strs, int m, int n) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            int one = 0;
            int zero = 0;
            for (char ch : str.toCharArray()){
                if (ch == '1') one++;
                else zero++;
            }

            for (int i = m; i >= zero; i--){
                for (int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
