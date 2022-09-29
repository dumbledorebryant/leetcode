package pass;

import java.util.Deque;
import java.util.LinkedList;

public class lc1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        int[] count = new int[length];
        for (int i = 0; i < sb.length(); i++){
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
                count[i] = 1;
            }
            else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k){
                    sb.delete(i + 1 - k, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
