package pass;

public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] front = new int[length + 1];
        int[] back = new int[length + 1];
        front[0] = 1;
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            front[i] = front[i - 1] * num;
        }
        back[length] = 1;
        for (int i = length - 1; i >= 0; i--){
            int num = nums[i];
            back[i] = back[i + 1] * num;
        }
        
        int[] ans = new int[length];
        for (int i = 0; i < length; i++){
            ans[i] = front[i] * back[i + 1];
        }
        return ans;
    }
}
