package pass;

public class lc31 {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int nums[], int num){
        int length = nums.length;
        int left = num;
        int right = length - 1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
