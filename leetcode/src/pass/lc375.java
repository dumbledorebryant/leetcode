package pass;

public class lc375 {
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[][] dp = new int[n + 2][n + 2];

        for (int sublen = 1; sublen < n; sublen++){
            for (int start = 1; start + sublen <= n; start++){
                int end = start + sublen;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++){
                    int temp = k + Math.max(dp[start][k - 1], dp[k + 1][end]);
                    dp[start][end] = Math.min(dp[start][end], temp);
                }
            }
        }
        return dp[1][n];
    }
}
