package pass;

import java.util.*;

public class lc291 {
    boolean ans = false;
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrace(pattern, s, 0, 0);
    }

    public boolean backtrace(String pattern, String s, int idx, int ptr){
        int length = s.length();
        int plen = pattern.length();
        if (idx == length && ptr == plen) {
            return true;
        }

        if (idx == length || ptr == plen){
            return false;
        }

        if (idx > length || ptr > plen) return false;

        char ch = pattern.charAt(ptr);
        if (map.containsKey(ch)){
            String key = map.get(ch);
            int slen = key.length();
            if (slen + idx > length) return false;
            if (s.substring(idx).startsWith(key)){
                return backtrace(pattern, s, idx + slen, ptr + 1);
            }
            else return false;
        }

        for (int i = idx; i < length; i++){
            String str = s.substring(idx, i + 1);
            if (set.contains(str)) continue;
            int slen = str.length();
            map.put(ch, str);
            set.add(str);
            boolean res = backtrace(pattern, s, idx + slen, ptr + 1);
            map.remove(ch);
            set.remove(str);
            if (res) return true;
        }

        return false;
    }
}
