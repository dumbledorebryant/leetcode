package pass;

public class lc2222 {
    public long numberOfWays(String s) {
        long ans = 0, n0 = 0, n01 = 0, n10 = 0, n1 = 0;
        char[] chrs = s.toCharArray();
        for (char ch : chrs)
        {
            if (ch == '0'){
                n0++;
                n10 += n1;
                ans += n01;
            }
            else {
                n1++;
                n01 += n0;
                ans += n10;
            }
        }
        return ans;
    }
}
