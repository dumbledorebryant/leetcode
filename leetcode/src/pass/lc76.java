package pass;

import java.util.*;

public class lc76 {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tlen; i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minleft = 0;
        int minlen = slen + 1;
        while (right < slen){
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) count++;
            }
            while (count == tlen){
                if (right - left + 1 < minlen){
                    minleft = left;
                    minlen = right - left + 1;
                }
                char lch = s.charAt(left);
                if (map.containsKey(lch)){
                    map.put(lch, map.get(lch) + 1);
                    if (map.get(lch) > 0) count--;
                }
                left++;
            }
            right++;
        }
        if (minlen == slen + 1) return "";
        return s.substring(minleft, minleft + minlen);
    }
}
