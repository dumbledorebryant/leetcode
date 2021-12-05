package pass;

import java.util.*;
import java.util.Map.Entry;

public class lc451 {
    public String frequencySort(String s) {
        char[] chs = s.toCharArray();
        int length = chs.length;
        if (length <= 1) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            char item = chs[i];
            map.put(item, map.getOrDefault(item, 0));
        }
        
        return chs.toString();
    }
}
