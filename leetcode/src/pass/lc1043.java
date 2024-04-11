package pass;

public class lc1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= Math.min(i, k); j++){
                int max = -1;
                for (int l = i - 1; l >= i - j; l--) {
                    max = Math.max(max, arr[l]);
                }
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }
        return dp[n];
    }
}
