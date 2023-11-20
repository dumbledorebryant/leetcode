package pass;

import java.util.ArrayList;
import java.util.List;

public class lc1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        
        int n = intervals.length;
        int lb = toBeRemoved[0];
        int rb = toBeRemoved[1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int[] interval = intervals[i];
            int left = interval[0];
            int right = interval[1];
            if (right <= lb || left >= rb){
                List<Integer> cur = new ArrayList<>();
                cur.add(left);
                cur.add(right);
                ans.add(cur);
                continue;
            }
            if (lb > left && rb < right){
                List<Integer> lcur = new ArrayList<>();
                lcur.add(left);
                lcur.add(lb);
                ans.add(lcur);
                List<Integer> rcur = new ArrayList<>();
                rcur.add(rb);
                rcur.add(right);
                ans.add(rcur);
                continue;
            }
            if (left >= lb && right <= rb){
                continue;
            }

            if (left < lb){
                List<Integer> cur = new ArrayList<>();
                cur.add(left);
                cur.add(lb);
                ans.add(cur);
            }
            if (left >= lb){
                List<Integer> cur = new ArrayList<>();
                cur.add(rb);
                cur.add(right);
                ans.add(cur);
            }
        }
        return ans;
    }
}
