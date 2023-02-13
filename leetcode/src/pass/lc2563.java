package pass;

import java.util.Arrays;

public class lc2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = n - 1; 
        int h = n - 1;
        long ans = 0;
        for (int i = 0; i < n; i++){
            while (l >= 0 && nums[i] + nums[l] >= lower) l--;
            while (h >= 0 && nums[i] + nums[h] > upper) h--;
            ans += (h - l);
            if (i > l && i <= h) ans--;
        }
        return ans/2;
    }

}
