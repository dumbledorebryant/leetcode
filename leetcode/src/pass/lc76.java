package pass;

import java.util.*;

public class lc76 {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int slen = ss.length;
        int tlen = ts.length;
        if (slen < tlen) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tlen; i++){
            map.put(ts[i], 0);
        }

        int left = 0;
        int right = slen - 1;
        for (int i = 0; i < slen; i++){
            char item = ss[i];
            if (map.containsKey(item)) map.put(item, map.get(item) + 1);
            else continue;
            if (checkall(map) == true){

            }
        }
        return "";
    }

    public boolean checkall(Map<Character, Integer> map){
        Set<Character> keys = map.keySet();
        for (int key : keys){
            if (map.get(key) == 0) return false;
        }
        return true;
    }
}
