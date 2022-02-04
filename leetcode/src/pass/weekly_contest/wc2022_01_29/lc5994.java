package pass.weekly_contest.wc2022_01_29;

public class lc5994 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int length = s.length();
        if (k == length) return s;
        String ans = "";
        for (int i = 0; i <= length - k; i++){
            String str = s.substring(i, i + k);
            long res = calc(str, power, modulo);
            if (res == hashValue) {
                ans = str;
                break;
            }
        }
        return ans;
    }
    public long calc(String str, int power, int modulo){
        int k = str.length();
        if (k == 0) return 0;
        
        char start = str.charAt(0);
        long res = (long)Math.pow(start, 0);
        long ans = (start - 'a' + 1) * res;
        for (int i = 1; i < k; i++){
            char ch = str.charAt(i);
            int val = ch - 'a' + 1;
            res *= power;
            ans += (long)val * res;
        }
        return (long)(ans % (long)modulo);
    }

    public String subSHash(String s, int power, int modulo, int k, int hashValue) {
        long pow = 1, hash = 0;
        int res = -1;
        for (int i = s.length() - k + 1; i < s.length(); i++) {
            hash += pow * (s.charAt(i) - 'a' + 1);
            hash %= modulo;
            pow *= power;
            pow %= modulo;
        }
        for (int i = s.length() - k; i >= 0; i--) {
            if (i < s.length() - k) {
                hash += modulo;
                hash -= pow * (s.charAt(i + k) - 'a' + 1) % modulo;
                hash %= modulo;
            }
            hash *= power;
            hash %= modulo;
            hash += s.charAt(i) - 'a' + 1;
            hash %= modulo;
            if (hash == hashValue) {
                res = i;
            }
        }
        return s.substring(res, res + k);
    }
}
