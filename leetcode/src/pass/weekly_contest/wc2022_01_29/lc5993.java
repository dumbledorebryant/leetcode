package pass.weekly_contest.wc2022_01_29;

import java.util.Arrays;

public class lc5993 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int length = nums.length;
        int i = 0;
        while (i < length){
            int num = nums[i];
            if (num == original){
                original *= 2;
            }
            i++;
        }
        return original;
    }
}
