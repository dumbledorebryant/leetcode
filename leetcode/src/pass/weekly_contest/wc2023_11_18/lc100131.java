package pass.weekly_contest.wc2023_11_18;

public class lc100131 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();
        
        int min = Math.min(a, Math.min(b, c));
        int i = 0;
        for (; i < min; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s3.charAt(i);
            if (c1 != c2 || c2 != c3){
                break;
            }
        }
        if (i == 0) return -1;
        int ans = 0;
        ans = a - i + b - i + c - i;
        return ans;
    }
}
