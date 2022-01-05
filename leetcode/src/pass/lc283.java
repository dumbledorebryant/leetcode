package pass;

public class lc283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int pos = 0;
        int ptr = 0;
        for (; ptr < length; ptr++){
            if (nums[ptr] != 0){
                int num = nums[ptr];
                nums[ptr] = 0;
                nums[pos]= num;
                pos++;
            }
        }
    }
}
