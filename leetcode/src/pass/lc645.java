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

    public int[] finderror(int[] nums){
        int length = nums.length;
        int dup = -1;
        int missing = -1;
        for (int i = 0; i < length; i++){
            int num = Math.abs(nums[i]) - 1;
            int inum = nums[num];
            if (inum < 0) dup = num + 1;
            else nums[num] = -nums[num];
        }
        for (int i = 0; i < length; i++){
            if (nums[i] > 0) missing = i + 1;
        }
        return new int[]{dup, missing};
    }
}
