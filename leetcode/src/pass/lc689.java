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
        if (k == 0) return true;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (!visited.contains(i)){
                int cur = pre + num;
                if (cur == sub) {
                    visited.add(i);
                    if (!backtrace(nums, k - 1, 0)) visited.remove(i);
                }
                else if (cur < num){
                    visited.add(i);
                    if (!backtrace(nums, k, cur)) visited.remove(i);
                }
                else continue;
            } 
            else continue;
        }
        return false;
    }
}
