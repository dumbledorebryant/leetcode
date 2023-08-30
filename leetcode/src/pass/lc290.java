package pass;

import java.util.*;

public class lc290{
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> smap = new HashMap<>(); 
        String[] list = s.split(" ");
        int n = pattern.length();
        int m = list.length;
        if (n != m) return false;
        for (int i = 0; i < n; i++){
            char ch = pattern.charAt(i);
            String str = list[i];
            if (map.containsKey(ch)){
                if (!map.get(ch).equals(str)) return false;
            }
            else if (smap.containsKey(str)){
                if (smap.get(str) != ch) return false;
            }
            else {
                map.put(ch, str);
                smap.put(str, ch);
            }
        }
        return true;
    }
}