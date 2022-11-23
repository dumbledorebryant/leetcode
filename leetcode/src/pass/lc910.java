package pass;

import java.util.*;

public class lc910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int omax = nums[n - 1];
        int omin = nums[0];
        int ans = omax - omin;
        for (int i = 0; i < n - 1; i++){
            int max = Math.max(nums[i] + k, omax - k);
            int min = Math.min(nums[i + 1] - k, omin + k);
            ans = Math.min(max - min, ans);
        }
        return ans;
    }
}
