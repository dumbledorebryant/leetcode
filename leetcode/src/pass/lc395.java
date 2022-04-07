package pass;
import java.util.*;
public class lc395 {
    public int longestSubstring(String s, int k) {
        int length = s.length();
        if (length < k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        for (char ch : chrs){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : chrs){
            if (map.get(ch) < k){
                String[] strs = s.split(String.valueOf(ch));
                int ans = 0;
                for (String str : strs){
                    ans = Math.max(ans, longestSubstring(str, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}
