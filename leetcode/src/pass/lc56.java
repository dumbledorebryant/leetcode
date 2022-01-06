package pass;

import java.util.ArrayList;
import java.util.*;

public class lc56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        int length = intervals.length;
        int[] start = intervals[0];
        int left = start[0];
        int right = start[1];
        for (int i = 1; i < length; i++){
            int[] inter = intervals[i];
            int l = inter[0];
            int r = inter[1];
            if (l <= right && r > right) right = r;
            if (l > right) {
                list.add(new int[]{left, right});
                left = l;
                right = r;
            }
        }
        list.add(new int[]{left, right});
        int len = list.size();
        int[][] ans = new int[len][];
        for (int i = 0; i < len; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
