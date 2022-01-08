package pass;

public class lc392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int pos = 0;
        int ptr = 0;
        while (pos < slen && ptr < tlen) {
            if (s.charAt(pos) == t.charAt(ptr)) {
                pos++;
            }
            ptr++;
        }
        if (pos == slen) return true;
        else return false;
    }
}
