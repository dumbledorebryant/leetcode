package pass;

public class lc1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        int t = sum - x;

        int left = 0;
        int right = 0;
        int n = nums.length;

        int cur = 0;
        int len = Integer.MIN_VALUE;
        while (right < n){
            int num = nums[right];
            cur += num;
            right++;

            while (cur > t && left < right){
                cur -= nums[left];
                left++;
            }
            if (cur == t){
                len = Math.max(len, right - left);
            }
        }
        return len == Integer.MIN_VALUE ? -1 : n - len;
    }
}
