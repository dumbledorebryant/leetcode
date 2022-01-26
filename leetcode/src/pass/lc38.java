package pass;

public class lc38 {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++){
            int m = ans.length();
            String cur = "";
            for (int j = 0; j < m;){
                int k = j + 1;
                char ch = ans.charAt(j);
                while (k < m && ans.charAt(k) == ch){
                    k++;
                }
                int count = k - j;
                cur += count + "" + ch;
                j = k;
            }
            ans = cur;
        }
        return ans;
    }
}
