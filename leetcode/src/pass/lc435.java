package pass;

import java.util.Arrays;

public class lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int length = intervals.length;
        if (length <= 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++){
            if (intervals[i][0] < edge){
                count++;
            }
            else {
                edge = intervals[i][1];
            }
        }
        return count;
    }
}
