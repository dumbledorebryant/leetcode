package pass;

import java.util.HashMap;
import java.util.Map;

public class lc266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;
        for (char ch : map.keySet()){
            if (map.get(ch) % 2 == 1) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}
