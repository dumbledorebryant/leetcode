package pass;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < length){
            int num = nums[right];
            sum += num;
            while (sum >= k){
                if (sum == k) count++;
                int pre = nums[left];
                sum -= pre;
                left++;
            }
            right++;
        }
        return count;
    }
}
