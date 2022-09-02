package pass;

import java.util.Arrays;

public class lc719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = nums[length - 1] - nums[0];
        
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (cnt(nums, mid) >= k){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int cnt(int[] nums, int target){
        int ans = 0;
        int length = nums.length;
        int left = 0; 
        int right = 0;
        while (right < length){
            right++;
            while (nums[right] - nums[left] > target){
                left++;
            }
            ans += (right - left);
        }
        return ans;
    }
}
