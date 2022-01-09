package pass;

import java.util.Arrays;

public class lc452 {
    public int findMinArrowShots(int[][] points) {
        int length = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            if (a[1] == b[1]) return 0;
            else return -1;
        });
        int[] prev = points[0];
        int right = prev[1];
        int count = 1;
        for (int i = 1; i < length; i++){
            int[] curr = points[i];
            int a = curr[0];
            int b = curr[1];
            if (a > right) {
                count++;
                right = b;
            }
        }
        return count;
    }
}
