package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc901 {
    class StockSpanner {
    Deque<int[]> dq = new ArrayDeque<>();
    int idx = 0;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if (dq.isEmpty()){
            dq.addLast(new int[]{price, 1});
            return 1;
        }
        int prev = 0;
        while (!dq.isEmpty() && price >= dq.getLast()[0]){
            int[] item = dq.removeLast();
            prev += item[1];
        }
        
        int ans = 1 + prev;
        dq.addLast(new int[]{price, ans});
        return ans;
    }
}
}
