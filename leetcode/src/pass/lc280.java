package pass;

import java.util.Arrays;

public class lc280 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] cp = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++){
            if (i % 2 == 0)
                nums[i] = cp[i / 2];
            else {
                nums[i] = cp[n - 1 - i / 2];
            }
        }
    }


    public void wiggleSort2(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1) != (nums[i] > nums[i - 1])) {
                int cache = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = cache;
            }
        }
    }
}
