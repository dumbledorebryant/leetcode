package pass;

public class lc268 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int ans = ((length + 1) * length) / 2;
        for (int num : nums){
            ans -= num;
        }
        return ans;
    }
}
