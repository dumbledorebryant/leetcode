package pass;

public class lc1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;
        int cur = 0;
        int ans = 0;
        int temp = 0;
        while (right < n){
            int num = nums[right];
            right++;
            if (num % 2 == 1) {
                temp = 0;
                cur++;
            }

            while (cur == k){
                temp++;
                if (nums[left] % 2 == 1) cur--;
                left++;
            }
            
            ans += temp;
            
        }
        return ans;
    }
}
