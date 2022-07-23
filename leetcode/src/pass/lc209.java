package pass;

public class lc209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int ans = length + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < length){
            sum += nums[right];
            while (sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (ans == length + 1) return 0;
        else return ans;
    }
}
