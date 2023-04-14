package pass;

import java.util.Arrays;

public class lc313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        if (n == 1) return 1;
        int size = primes.length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < size; j++){

            }
        }
    }
}
