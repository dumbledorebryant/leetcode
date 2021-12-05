package pass;

public class lc1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int find = 0;
        int length = s.length();
        for (int i = 0; i < length; i++){
            char item = s.charAt(i);
            if (item == 'L'){
                find++;
            } 
            else find--;
            if (find == 0) count++;
        }
        return count;
    }
}
