package pass;

public class lc1541 {
    public int minInsertions(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int need = 0;
        int ans = 0;
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            if (ch == '(') {
                need += 2;
                if (need % 2 == 1) {
                    ans++;
                    need--;
                }
            }
            if (ch == ')') {
                need--;
                if (need == -1){
                    ans++;
                    need = 1;
                }
            }
        }
        return ans + need;
    }
}
