package pass.OA.Expedia;

public class BinaryGame {
    public int find(int minlen, int maxlen, int one, int zero){
        int[] dp = new int[maxlen + 1];
        dp[one] = 1;
        dp[zero] = 1;
        for (int i = 1; i <= maxlen; i++){
            if (i - one >= 0)
                dp[i] += dp[i - one];
            if (i - zero >= 0)
                dp[i] += dp[i - zero];
        }
        int sum = 0;
        for (int i = minlen; i <= maxlen; i++){
            sum += (dp[i] % 1000000007);
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryGame bg = new BinaryGame();
        System.out.println(bg.find(1, 3, 2, 1));
    }
}
