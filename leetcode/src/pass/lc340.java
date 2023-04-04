package pass;
import java.util.*;;
public class lc340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int left = 0; 
        int right = 0;
        int ans = 0;
        while (right < length){
            char ch = chrs[right];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            right++;
            while (map.size() > k){
                char lch = chrs[left];
                map.put(lch, map.get(lch) - 1);
                if (map.get(lch) == 0) map.remove(lch);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
