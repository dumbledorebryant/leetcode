package pass;

import java.util.*;

public class lc424 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int left = 0; 
        int right = 0;
        int ans = 0;
        while (right < length){
            char ch = chrs[right];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            right++;
            if (right - left + 1 < ans + k){
                
            }
        }
    }
}
