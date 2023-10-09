package pass;

public class lc2311 {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int sum = 0;
        boolean need = true;
        for (int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if (ch == '0'){
                cnt++;
            }
            else if (need){
                sum += Math.pow(2, n - 1 - i);
                if (sum <= k){
                    cnt++;
                }
                else need = false;
            }
        }
        return cnt;
    }
}
