package pass;

public class lc905 {
    public int[] sortArrayByParity(int[] nums) {
        int slow = 0;
        int fast = 0;
        int length = nums.length;
        while (fast < length){
            if (nums[fast] % 2 == 0){
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}
