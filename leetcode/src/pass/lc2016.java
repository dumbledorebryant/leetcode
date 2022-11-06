package pass;

import java.util.ArrayDeque;
import java.lang.reflect.Array;
import java.util.*;

public class lc2016 {
    public int maximumDifference(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int min = nums[0];
        for (int i = 1; i < n; i++){
            int num = nums[i];
            ans = Math.max(ans, num - min);
            min = Math.min(min, num);
        }
        if (ans <= 0) return -1;
        return ans;
    }
}
