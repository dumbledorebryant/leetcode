package pass;

public class lc397 {
    public int integerReplacement(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int bit = 1;
        int a = n;
        while (a >= 0){
            a = a / 2;
            bit++;
        }
        int[] dp = new int[bit];
        for (int i = 0; i < bit; i++){
            int num = (n >> i) & 1;
            if (num == 0){
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = dp[i - 1] + 2;
            }
        }
        return dp[bit];
    }
}
