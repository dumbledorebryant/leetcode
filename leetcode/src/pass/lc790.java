package pass;
public class lc790 {
    public int numTilings(int n) {
        if (n <= 2) return n;
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if (n >= 3) dp[3] = 5; 
        for (int i = 4; i <= n; i++){
            dp[i] = ((2 * dp[i - 1]) % mod + (dp[i - 3] % mod)) % mod;
        }
        return dp[n];
    }
}
