package pass;

public class lc921 {
    public int minAddToMakeValid(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count < 0) {
                ans++;
                count = 0;
            }
        }
        if (count > 0) ans += count;
        return ans;
    }
}
