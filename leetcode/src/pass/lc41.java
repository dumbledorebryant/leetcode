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

    public int findMissing(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int num = nums[i];
            if (num < n && num > 0){
                if (nums[num - 1] == num) continue;
                else {
                    // nums[num] != num
                    int j = i;
                    int k = num - 1;
                    while (nums[k] != nums[j]){
                        swap(nums, k, j);
                        j = nums[k];
                        k = nums[j] - 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1) return i + 1;
        }
        return -1;
    }
}
