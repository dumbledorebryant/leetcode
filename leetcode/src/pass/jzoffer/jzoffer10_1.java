package pass.jzoffer;

public class jzoffer10_1 {
    public int fib (int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        
        int a = 0;
        int b = 1;
        int sum = 0;

        int mod = (int)1e9+7;
        
        for (int i = 2; i <= n; i++){
            sum = a + b;
            sum %= mod;
            a = b;
            b = sum;
        }
        return sum;
    }
}
