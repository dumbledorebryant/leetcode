package pass;

public class lc26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int pos = 0;
        int ptr = 0;
        for (; ptr < length; ptr++){
            while (nums[ptr] == nums[pos]){
                ptr++;
                if (ptr >= length) return pos + 1;
            }
            pos++;
            nums[pos] = nums[ptr];
        }
        return pos + 1;
    }
}
