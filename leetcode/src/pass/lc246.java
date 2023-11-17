package pass;

import java.util.HashMap;
import java.util.Map;

public class lc246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int a = 0;
        int b = num.length() - 1;
        while (a < b){
            char l = num.charAt(a);
            char r = num.charAt(b);
            if (!map.containsKey(l)) return false;
            if (map.get(l) != r) return false;
            a++;
            b--;
        }
        if (a == b){
            char ch = num.charAt(a);
            if (ch != '1' && ch != '0' && ch != '8') return false;
        }
        return true;
    }
}
