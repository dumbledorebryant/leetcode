package pass;

import java.util.Arrays;

public class lc313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        return 0;
    }
    public int nSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        if (n == 1) return 1;
        int size = primes.length;
        int[] dp = new int[n + 1];
        int[] ptrs = new int[size];
        Arrays.fill(ptrs, 1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++){
                int idx = dp[ptrs[j]];
                int num = primes[j];
                int val = idx * num;
                min = Math.min(val, min);
            }
            for (int j = 0; j < size; j++){
                int idx = dp[ptrs[j]];
                int num = primes[j];
                int val = idx * num;
                if (val == min) ptrs[j]++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
