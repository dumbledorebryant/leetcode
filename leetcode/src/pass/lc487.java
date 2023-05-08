package pass;

public class lc487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int left = 0; 
        int right = 0;
        boolean flag = false;
        int ans = 0;
        while (right < length){
            int num = nums[right];
            right++;
            
            if (flag && num == 0){
                while (left <= right && nums[left] == 1){
                    left++;
                }
                flag = false;
                left++;
            }
            
            if (!flag && num == 0) flag = true;
            ans = Math.max(ans, right - left);            
        }
        return ans;
    }
}
