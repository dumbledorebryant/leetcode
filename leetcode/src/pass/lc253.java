package pass;

import java.util.*;

public class lc253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        int length = intervals.length;
        for (int i = 1; i < length; i++){
            int[] meeting = intervals[i];
            int start = meeting[0];
            if (start >= queue.peek()){
                queue.poll();
            }
            queue.add(meeting[1]);
        }
        return queue.size();
    }
}
