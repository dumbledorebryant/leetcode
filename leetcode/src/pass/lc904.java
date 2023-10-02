package pass;

import java.util.HashMap;
import java.util.Map;

public class lc904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n){
            int type = fruits[right];
            right++;
            map.put(type, map.getOrDefault(type, 0) + 1);
            if (map.size() <= 2) ans = Math.max(ans, right - left);
            while (map.size() > 2){
                int pre = fruits[left];
                map.put(pre, map.get(pre) - 1);
                if (map.get(pre) == 0) map.remove(pre);
                left++;
            }
        }
        return ans;
    }
}
