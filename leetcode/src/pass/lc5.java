package pass;

public class lc5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        String str = "";
        for (int i = 0; i < length; i++){
            String a = findp(s, i, i);
            String b = findp(s, i, i + 1);
            int alen = a.length();
            int blen = b.length();
            int slen = str.length();
            str = alen > slen ? a : str;
            str = blen > slen ? b : str;
        }
        return str;
    }

    public String findp(String str, int left, int right){
        while (left >= 0 && right <= str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
