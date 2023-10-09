package pass;

import java.util.HashMap;
import java.util.Map;

public class lc1137 {
    Map<Integer, Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int ans = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        map.put(n, ans);
        return ans;
    }
}
