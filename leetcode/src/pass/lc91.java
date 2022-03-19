package pass;

public class lc91 {
    public int numDecodings(String s) {
        int length = s.length();
        s = " " + s;
        int[] dp = new int[length + 1];
        char[] chrs = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= length; i++){
            int a = chrs[i] - '0';
            int b = a + (chrs[i - 1] - '0') * 10;
            if (a != 0){
                dp[i] = dp[i - 1];
            }

            if (b <= 26 && b >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[length];
    }
    public int cisco_numDecodings(String s) {
        int length = s.length();
        s = " " + s;
        int[] dp = new int[length + 1];
        char[] chrs = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= length; i++){
            int a = chrs[i] - '0';
            int b = a + (chrs[i - 1] - '0') * 10;
            
            dp[i] = dp[i - 1];
            
            
            if (b <= 26 && b >= 1) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[length];
    }
}
