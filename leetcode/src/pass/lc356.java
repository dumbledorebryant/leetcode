package pass;

import java.util.HashSet;
import java.util.Set;

public class lc356 {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Set<String> set = new HashSet<>();
        for (int[] pt : points){
            max = Math.max(max, pt[0]);
            min = Math.min(min, pt[0]);
            set.add(pt[0] + "x" + pt[1]);
        }
        int sum = max + min;
        for (int[] pt : points){
            int oppo = sum - pt[0];
            if (!set.contains(oppo + "x" + pt[1])) return false;
        }
        return true;
    }
}
