package pass;

import java.util.*;

public class lc689 {
    Set<Integer> visited = new HashSet<>();
    int sub;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        int left = sum % k;
        if (left != 0) return false;
        sub = sum / k;
        return backtrace(nums, k, 0);
    }
    public boolean backtrace(int[] nums, int k, int pre){
        int size = visited.size();
        int len = nums.length;
        if (k == 0 && size == len){
            return true;
        }
        if (k == 0) return false;
        if (size == len) return false;
        for (int num : nums){
            int cur = pre + num;
            if (!visited.contains(num) && cur == sub){
                visited.add(num);
                backtrace(nums, k - 1, 0);
            }
            else if (!visited.contains(num) && cur < sub){
                visited.add(num);
                backtrace(nums, k, sub - cur);
            }
            else continue;
        }
        return false;
    }
}
