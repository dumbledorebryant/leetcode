package pass;

import java.util.*;

public class lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < length){
            int num = nums[right];
            
            if (map.containsKey(num)) return true;
            map.put(num, 1);
            while (right - left >= k){
                int lnum = nums[left];
                map.remove(lnum);
                left++;
            }
            right++;
        }
        return false;
    }
}
