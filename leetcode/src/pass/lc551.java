package pass;

public class lc551 {
    public boolean checkRecord(String s) {
        int ca = 0;
        int cl = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == 'A'){
                ca++;
                if (ca == 2) return false;
            }
            if (ch == 'L'){
                cl++;
                if (cl >= 3) return false;
            }
            else cl = 0;
        }
        return true;
    }
}
