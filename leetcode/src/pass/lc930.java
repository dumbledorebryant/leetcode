package pass;

public class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++){
            int num = nums[i];
            sum += num;
            int left = sum - goal;
            if (left >= 0){
                ans += count[left];
            }
            count[sum]++;
        }
        return ans;
    }
}
