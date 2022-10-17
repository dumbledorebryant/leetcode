package pass;

import java.util.*;

public class lc424 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < length){
            char ch = chrs[r];
            r++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max = Math.max(max, map.get(ch));
            if (r - l > max + k){
                char left = chrs[l];
                map.put(left, map.get(left) - 1);
                l++;
            }
        }
        return r - l;
    }
}
