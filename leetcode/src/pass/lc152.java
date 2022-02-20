package pass;

public class lc152 {
    public int maxProduct(int[] nums) {
        int ma = nums[0];
        int mi = nums[0];
    
        int ans = nums[0];
        int length = nums.length;
        for(int i = 1; i < length; i++){
            int num = nums[i];
            int temp = ma;
            ma = Math.max(num, Math.max(ma * num, mi * num));
            mi = Math.min(num, Math.min(mi * num, temp * num));
            ans = Math.max(ma, ans);
        }
        return ans;
    }
}
