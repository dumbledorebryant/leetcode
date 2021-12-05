package pass;

public class lc678 {
    public boolean checkValidString(String s) {
        int length = s.length();
        int low = 0;
        int high = 0;
        for (int i = 0; i < length; i++) {
            char item = s.charAt(i);
            if (item == '(') {
                low++;
                high++;
            }

            if (item == ')') {
                low--;
                high--;
            }

            if (item == '*') {
                low--;
                high++;
            }

            low = Math.max(low, 0);
            if (low > high) return false;
        }
        
        return low == 0;

    }
}
