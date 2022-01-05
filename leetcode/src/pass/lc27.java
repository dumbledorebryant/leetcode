package pass;

public class lc27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int pos = 0;
        
        for (int ptr = 0; ptr < length; ptr++){
            if (nums[ptr] != val) {
                nums[pos] = nums[ptr];
                pos++;
            }
        }
        return pos;
    }
}
