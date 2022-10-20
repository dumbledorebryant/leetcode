package pass;

import java.util.Arrays;

public class lc252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        int length = intervals.length;
        for (int i = 1; i < length; i++){
            int[] meeting = intervals[i];
            int start = meeting[0];
            if (start < end) return false;
            end = meeting[1];
        }
        return true;
    }
}
