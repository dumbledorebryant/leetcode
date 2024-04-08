package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--){
            int num = heights[i];
            int count = 0;
            while (!dq.isEmpty() && heights[dq.getFirst()] < num){
                int idx = dq.removeFirst();
                count++;
            }
            res[i] = dq.isEmpty() ? count : count + 1;
            dq.addFirst(i);
        }
        
        return res;
    }
}
