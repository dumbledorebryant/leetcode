package pass;

import java.util.HashMap;
import java.util.Map;

public class lc217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int key = nums[i];
            if (map.containsKey(key)) return true;
            map.put(key, 0);
        }
        return false;
    }
}
