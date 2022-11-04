package pass;

import java.util.Arrays;

public class lc1024 {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
       
        if (clips[0][0] != 0){
            return -1;
        }

        int end = clips[0][1];
        int ans = 1;
        int i = 1;
        while (i < n){
            if (end >= time){
                return ans;
            }
            int max = end;
            while(i < n && clips[i][0] <= end){
                max = Math.max(max, clips[i][1]);
                i++;
            }
            if (end == max){
                return -1;
            }
            end = max;
            ans++;
        }
        return end >= time? ans : -1;
    }
}
