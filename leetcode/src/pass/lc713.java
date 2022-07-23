package pass;

public class lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int length = nums.length;
        int count = 0;
        int left = 0;
        int right = 0;
        int mul = 1;
        while (right < length){
            mul *= nums[right];
            while (mul >= k){
                mul /= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
