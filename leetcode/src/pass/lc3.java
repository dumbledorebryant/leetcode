package pass;

import java.util.*;

public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chrs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int idx = 0;
        int length = chrs.length;
        int ans = 0;
        int left = 0;
        while(idx < length){
            char ch = chrs[idx];
            if (!set.contains(ch)){
                set.add(ch);
            }
                
            else {
                ans = Math.max(ans, idx - left);
                while (left < length && chrs[left] != ch){
                    set.remove(chrs[left]);
                    left++;
                }
                left++;
            }
            
            idx++;
        }
        ans = Math.max(ans, idx - left);
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
