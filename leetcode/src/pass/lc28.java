package pass;

public class lc28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        if (haystack.equals("")) return -1;
        int length = haystack.length();
        int len = needle.length();
        int i = 0, j = 0;
        while (i < length && j < len){
            char a = haystack.charAt(i);
            char b = haystack.charAt(j);
            if (a == b) {
                i++;
                j++;
                if (j == len) return i - len;
            }
            else{
                i++;
                j = 0;
            }
        }
        return -1;
    }
}
