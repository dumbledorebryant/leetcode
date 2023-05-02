package pass;

import java.util.*;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int[] prefix = new int[length + 1];
        for (int i = 1; i <= length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < length; i++){
            for (int j = i; j < length; j++){
                if (prefix[j + 1] - prefix[i] == k) count++;
            }
        }
        return count;
    }

    public int subSum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0;
        int count = 0;
        for (int num : nums){
            presum += num;
            if (map.containsKey(presum - k)){
                count += map.get(presum - k);
            }
            
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
