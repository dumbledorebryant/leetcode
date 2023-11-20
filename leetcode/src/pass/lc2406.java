package pass;

import java.util.Arrays;

public class lc2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = intervals.length;
        int[] left = new int[(int)(1e6 + 1)];
        int[] right = new int[(int)(1e6 + 1)];

        for (int[] interval : intervals){
            int l = interval[0];
            int r = interval[1];
            left[l]++;
            right[r]++;
        }
        int cur = 0;
        int ans = 0;
        for (int i = 0; i <= (int)(1e6); i++){
            cur += left[i];
            ans = Math.max(ans, cur);
            cur -= right[i];
        }
        return ans;
    }
}
