package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1130 {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.add(Integer.MAX_VALUE);
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            int num = arr[i];
            while (!dq.isEmpty() && num >= dq.getLast()){
                int pre = dq.removeLast();
                ans += Math.min(num, dq.getLast()) * pre;
            }
            dq.addLast(num);
        }
        while (dq.size() > 2){
            ans += (dq.removeLast() * dq.getLast());
        }
        return ans;
    }
}
