package pass;

public class lc413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length <= 2) return 0;
        int len = 0;
        int prev = 0;
        for (int i = 2; i < length; i++){
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                if (len == 0) len = 3;
                else len += 1;
            } 
            else {
                if (len != 0) {
                    for (int j = 2; j < len; j++){
                        prev += len - j;
                    }
                    len = 0;
                }
            }
        }
        if (len != 0) {
            for (int j = 2; j < len; j++){
                prev += len - j;
            }
        }

        return prev;
    }
    
}
