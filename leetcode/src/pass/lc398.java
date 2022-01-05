package pass;

import java.util.Random;

public class lc398 {
    int[] nums;
    public lc398(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random r = new Random();
        int i = 0;
        int index = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] == target){
                i++;
                if (r.nextInt(i) == 0) index = i;
            }
        }
        return index;
    }
}
