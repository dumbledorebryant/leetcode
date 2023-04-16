package pass;

import java.util.*;

public class lc313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            return a[0] - b[0];
        });

        int size = primes.length;
        for (int i = 0; i < size; i++){
            pq.offer(new int[]{1, primes[i], 1});
        }

        int[] ugly = new int[n + 1];
        int p = 1;

        while (p <= n){
            int[] pair = pq.poll();
            int product = pair[0];
            int prime = pair[1];
            int ptr = pair[2];

            if (product != ugly[p - 1]){
                ugly[p] = product;
                p++;
            }
            int[] next = new int[]{ugly[ptr] * prime, prime, ptr + 1};
            pq.offer(next);
        }

        return ugly[n];
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
