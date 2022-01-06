package pass;

import java.util.*;

public class lc1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;

        int[] start = intervals[0];
        int left = start[0];
        int right = start[1];
        for (int i = 1; i < length; i++){
            int[] inter = intervals[i];
            int l = inter[0];
            int r = inter[1];
            if (l >= left && r <= right){
                count++;
            }
            if (l > left && r > right){
                right = r;
            }
            if (l >= right){
                left = l;
                right = r;
            }
        }
        return length - count;
    }
}
