package pass;

import java.util.Arrays;

public class lc334 {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int num : nums){
            if (one > num) one = num;
            else if (two > num) two = num;
            else return true;
        }
        return false;
    }
}
