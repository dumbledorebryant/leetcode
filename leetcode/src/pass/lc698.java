package pass;

import java.util.*;

public class lc698 {
    int[] bucket;
    int target;
    int k;
    int[] memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        bucket = new int[k];
        
        int length = nums.length;
        memo = new int[length];

        Arrays.sort(nums);
        int i = 0, j = length - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        target = sum / k;
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int idx){
        int length = nums.length;
        if (idx == length){
            return true;
        }
        int num = nums[idx];
        for (int i = 0; i < k; i++){
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            if (num + bucket[i] > target) continue;
            
            bucket[i] += num;
            if (dfs(nums, idx + 1)) {
                return true;
            }
            bucket[i] -= num;
        }
        return false;
    }
}
