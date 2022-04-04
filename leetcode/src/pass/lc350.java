package pass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) map.put(item, map.getOrDefault(item, 0) + 1);
        
        List<Integer> list = new ArrayList<>();
        for (int item : nums2){
            if (map.containsKey(item) && map.get(item) != 0){
                list.add(item);
                map.put(item, map.get(item) - 1);
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        int i = 0;
        for (int item : list){
            ans[i] = item;
            i++;
        }
        return ans;
    }
}
