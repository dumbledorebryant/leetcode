package pass;

public class lc43 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] dp = new int[m + n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int a = Integer.valueOf(num1.substring(i, i + 1));
                int b = Integer.valueOf(num2.substring(j, j + 1));
                int num = a * b;
                int sum = num + dp[i + j];
                dp[i + j] += (sum % 10);
                dp[i + j + 1] += (sum / 10);
            }
        }
    
        String str = "";
        for (int i = m + n - 1; i >= 0; i--) str += String.valueOf(dp[i]);
        int valid = Integer.parseInt(str);
        return String.valueOf(valid);
    }
}
