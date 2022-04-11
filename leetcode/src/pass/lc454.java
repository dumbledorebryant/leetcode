package pass;

import java.util.HashMap;
import java.util.Map;

public class lc454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> mapab = new HashMap<>();
        for (int u : nums1){
            for (int v : nums2){
                mapab.put(u + v, mapab.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3){
            for (int v : nums4){
                int key = 0 - (u + v);
                if (mapab.containsKey(key)){
                    ans += mapab.get(key);
                }
            }
        }
        return ans;
    }
}
