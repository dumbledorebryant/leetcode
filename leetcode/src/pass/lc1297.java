package pass;

import java.util.HashMap;
import java.util.Map;

public class lc1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length(), start=0, end=0;
        Map<Character, Integer> map = new HashMap();
        Map<String, Integer> subStringMap = new HashMap();
        int res=0;
        while(end < n) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            end++;
            
            if (end-start == minSize) {
                String newString = s.substring(start, end);
                subStringMap.put(newString, subStringMap.getOrDefault(newString, 0)+1);
                if (map.size() <= maxLetters) {
                    res = Math.max(res, subStringMap.get(newString));
                }

                c = s.charAt(start);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                start++;
            }
            

        }
        return res;
    }
}
