package pass;

public class lc204 {
    int[] dp;
    public int countPrimes(int n) {
        dp = new int[n];
        int count = 0;
        for (int i = 2; i * i < n; i++){
            if (dp[i] == 1) continue;
            fill(i, n);
        }
        for (int i = 2; i < n; i++){
            if (dp[i] == 0) count++;
        }
        return count;
    }
    public void fill(int i, int n){
        int j = i * i;
        while (j < n){
            dp[j] = 1;
            j += i;
        }
    }
}
