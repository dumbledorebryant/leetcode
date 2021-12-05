package pass;

public class lc53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int[] array = new int[length + 1];
        array[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++){
            if (array[i] > 0) {
                array[i + 1] = array[i] + nums[i];
            }
            else array[i + 1] = nums[i];
        }
        for (int i = 1; i < length; i++){
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
