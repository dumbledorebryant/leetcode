package pass;

import java.util.HashMap;
import java.util.Map;

public class lc325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            sum += nums[i];
            int left = sum - k;
            if (left == 0){
                ans = i + 1;
            }
            if (map.containsKey(left)){
                ans = Math.max(ans, i - map.get(left));
            }
            map.putIfAbsent(sum, i);   
        }
        return ans;
    }
}
