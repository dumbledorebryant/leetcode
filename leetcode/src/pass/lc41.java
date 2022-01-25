package pass;

public class lc41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length){
            int num = nums[i];
            int index = num - 1;
            if (num > 0 && num <= length && num != nums[index]){
                swap(nums, index, i);
            }
            else i++;
        }
        for (int j = 0; j < length; j++){
            if (nums[j] != j + 1) return j + 1;
        }
        return length + 1;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
