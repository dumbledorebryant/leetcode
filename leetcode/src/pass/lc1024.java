package pass;

import java.util.Arrays;

public class lc1024 {
    public int videoStitching(int[][] clips, int time) {
        int length = clips.length;
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int count = 1;
        int[] start = clips[0];
        int right = start[1];
        for (int i = 1; i < length; i++){
            int[] curr = clips[i];
            int a = curr[0];
            int b = curr[1];
            int j = i;
            if (b <= right) continue;
            else if (b > right && a < right){
                count++;
                right = b;
            }
            else if (a == right){
                continue;
            }
            else if (a > right) return -1;
        }
        if (right < time) return -1;
        return count;
    }
}
