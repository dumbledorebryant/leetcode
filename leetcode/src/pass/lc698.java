package pass;

import java.util.*;

public class lc698 {
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k > nums.length){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }

        // 降序排列
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        if(nums[0] > sum/k){
            return false;
        }
        target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return backtrace(nums, k, 0, visited);
    }
    public boolean backtrace(int[] nums, int k, int pre, boolean[] visited){
        if (k == 0) return true;
        if (pre == target) return backtrace(nums, k - 1, 0, visited);
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (visited[i]) continue;
                
            int cur = pre + num;
            if (cur > target) continue;
            
            visited[i] = true;
            if (backtrace(nums, k, cur, visited)) return true;
            else visited[i] = false;
        }
        return false;
    }
}
