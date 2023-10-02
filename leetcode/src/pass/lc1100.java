package pass;

import java.util.HashMap;
import java.util.Map;

public class lc1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        int left = 0; 
        int right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n){
            char ch = s.charAt(right);
            right++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1 || map.size() > k){
                char p = s.charAt(left);
                left++;
                map.put(p, map.get(p) - 1);
                if (map.get(p) == 0) map.remove(p);
            }

            
            if (map.size() == k) ans++;
        }
        return ans;
    }
}
