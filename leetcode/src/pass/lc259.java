package pass;

import java.util.Arrays;

public class lc259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++){
            int m = nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r){
                int a = nums[l];
                int b = nums[r];
                if (m + a + b < target) {
                    ans += (r - l);
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return ans;
    }
}
