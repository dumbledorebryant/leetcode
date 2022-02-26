package pass;

import java.util.HashMap;
import java.util.Map;

public class lc242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) return false;
        for (int i = 0; i < slen; i++){
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for (int i = 0; i < tlen; i++){
            char key = t.charAt(i);
            if (map.containsKey(key)){
                map.put(key, map.get(key) - 1);
            }
            else return false;
        }
        for (char key : map.keySet()){
            if (map.get(key) != 0) return false;
        }
        return true;
    }
}
