package pass;

import java.util.*;

public class lc645 {
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int sum = ((length + 1) * length) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int dup = 0;
        for (int num : nums){
            if (map.containsKey(num)) {
                dup = num;
            }
            else {
                map.put(num, 1);
                sum -= num;
            }
        }
        return new int[]{dup, sum};
    }
}
