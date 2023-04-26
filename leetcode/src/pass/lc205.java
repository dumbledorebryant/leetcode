package pass;

import java.util.HashMap;
import java.util.Map;

public class lc205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        int alen = s.length();
        int blen = s.length();
        if (alen != blen) return false;
        for (int i = 0; i < blen; i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (smap.containsKey(sch)){
                if (smap.get(sch) != tch) return false;
            }
            if (tmap.containsKey(tch)){
                if (tmap.get(tch) != sch) return false;
            }
            
            smap.put(sch, tch);
            tmap.put(tch, sch);
        }
        return true;
    }
}
