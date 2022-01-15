package pass;

public class lc28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        if (haystack.equals("")) return -1;
        int length = haystack.length();
        int len = needle.length();
        for (int i = 0; i < length - len; i++){
            int j; 
            for (j = 0; j < len; j++){
                if (needle.charAt(j) != haystack.charAt(i + j)){
                    break;
                }
            }
            if (j == len) return i;
        }
        return -1;
    }
}
