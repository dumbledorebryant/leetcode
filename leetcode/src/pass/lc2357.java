package pass;

import java.util.*;

public class lc2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        int ans = 0;
        for (int num : nums){
            if (!set.contains(num) && cur < num){
                ans++;
                set.add(num);
                cur = num;
            }
        }
        return ans;
    }
}
