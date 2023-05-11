package pass;
import java.util.*;

public class lc1004 {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < length){
            int num = nums[right];
            right++;
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (num == 0 && map.get(num) > k){
                while (left < right){
                    int lnum = nums[left];
                    map.put(lnum, map.get(lnum) - 1);
                    left++;
                    if (lnum == 0) {
                        break;
                    }
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
