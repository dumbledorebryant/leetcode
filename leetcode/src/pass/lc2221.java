package pass;

public class lc2221 {
    public int triangularSum(int[] nums) {
        int length = nums.length;
        for (int i = length - 2; i >= 0; i++){
            sum(nums, i);
        }
        return nums[0];
    }

    public void sum(int[] nums, int length){
        for (int i = 0; i < length; i++){
            nums[i] = nums[i] + nums[i + 1];
            nums[i] = nums[i] % 10;
        }
    }
}
