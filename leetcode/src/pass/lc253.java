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

    public int minRooms(int[][] intervals){
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0; 
        int j = 0;
        int ans = 0;
        int count = 0;
        while (i < n && j < n){
            if (starts[i] < ends[j]){
                count++;
                i++;
                ans = Math.max(ans, count);
            }
            else {
                count--;
                j++;
            }
        }
        return ans;
    }
}
