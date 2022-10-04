package pass;

import java.util.*;

public class lc1044 {
    long[] h, p;
    public String longestDupSubstring(String s) {
        int P = 1313131;
        int n = s.length();
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 0; i < n; i++){
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l + r + 1)/2;
            String str = check(s, mid);
            if (!str.equals("")){
                l = mid + 1;
                ans = str;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public String check(String s, int len){
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++){
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[j - i + 1];
            if (set.contains(cur)) return s.substring(i - 1, j);
            else set.add(cur);
        }
        return "";
    }

    public static void main(String[] args) {
        lc1044 lc = new lc1044();
        System.out.println(lc.longestDupSubstring("aa"));
    }
}
