package pass;

public class lc634 {
    int mod = (int)1e9 + 7;
    public int findDerangement(int n) {
        if (n <= 2) return n - 1;
        long[] dp = new long[n + 1];
        dp[2] = 1l;
        for (int i = 3; i <= n; i++){
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % mod;
        }
        return (int)dp[n];
    }
}
