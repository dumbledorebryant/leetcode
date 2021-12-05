package pass;

import java.util.*;

public class lc447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            Map<Integer, Integer> pts = new HashMap<Integer, Integer>();
            for (int j = 0; j < length; j++){
                if (i == j) continue;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int dist = x * x + y * y;
                pts.put(dist, pts.getOrDefault(dist, 0) + 1);
            }

            for (int dist : pts.keySet()) {
                int cnt = pts.get(dist);
                ans += cnt * (cnt - 1);
            }
        }
        return ans;
    }
}
