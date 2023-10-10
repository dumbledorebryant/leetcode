package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            int num = heights[i];

            while (!dq.isEmpty() && num >= heights[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        int size = dq.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++){
            ans[i] = dq.removeFirst();
        }
        return ans;
    }
}
