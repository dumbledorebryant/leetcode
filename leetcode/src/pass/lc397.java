package pass;
import java.util.*;
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

    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement3(int n) {
        if (n == 2147483647) return 32;
        return find(n);
    }
    public int find(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        if (n % 2 == 0) res = 1 + integerReplacement(n/2);
        else res = 1 + Math.min(integerReplacement((n + 1)/2) + 1, integerReplacement(n - 1));
        map.put(n, res);
        return res;
    }
    public int integerReplacement2(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) return 0;
        if (n == 2) return 1;
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            if (i % 2 == 0) dp[i] = dp[i/2] + 1;
            else dp[i] = 1 + Math.min(dp[(i + 1)/2] + 1, dp[i - 1]);
        }
        return dp[n];
    }
}
