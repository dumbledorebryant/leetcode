package pass;

import java.util.Arrays;

public class lc567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] win1 = new int[26];
        int[] win2 = new int[26];
        int length = s1.length();
        int len = s2.length();
        if (len < length) return false;
        for (int i = 0; i < length; i++){
            win1[s1.charAt(i) - 'a']++;
            win2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(win1, win2)) return true;
        
        for (int i = length; i < len; i++){
            win2[s2.charAt(i - length) - 'a']--;
            win2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(win1, win2)) return true;
        }
        return false;
    }
}
