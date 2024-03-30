package pass;

public class lc1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int left = 0;
        int right = 0;
        int cur = 0;
        int ans = 0;
        while (right < n){
            int num = nums[right];
            right++;
            if (num == 0){
                cnt++;
            }
            else {
                cur++;
            }
            while (cnt >= 2){
                int pre = nums[left];
                left++;
                if (pre == 0){
                    cnt--;
                    break;
                }
                else {
                    cur--;
                }
            }
            ans = Math.max(ans, cur);
        }
        if (cnt == 0) return ans - 1;
        return ans;
    }
}
