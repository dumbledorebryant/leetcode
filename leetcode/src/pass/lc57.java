package pass;

import java.util.ArrayList;
import java.util.*;

public class lc57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int a = newInterval[0];
        int b = newInterval[1];
        int x = a; 
        int y = b;
        int end = 0;
        List<int[]> list = new ArrayList<>();
        boolean flag = false;
        for (int[] interval : intervals){
            int s = interval[0];
            int e = interval[1];
            end = Math.max(end, e);
            if (e < x){
                list.add(interval);
                continue;
            }
            if (s > y){
                if (!flag) list.add(new int[]{x, y});
                list.add(interval);
                continue;
            }
            if (s < a && e >= a){
                x = s;
            }
            if (s <= b && e >= b){
                y = e;
                list.add(new int[]{x, y});
                flag = true;
                continue;
            }
        }
        if (y > end) list.add(new int[]{x, y});
        int n = list.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
