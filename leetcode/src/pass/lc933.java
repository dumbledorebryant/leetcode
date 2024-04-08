package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc933 {
    Deque<Integer> dq = new ArrayDeque<>();
   
    public int ping(int t) {
        dq.addLast(t);

        while (!dq.isEmpty()){
            if (t - dq.getFirst() > 3000){
                dq.removeFirst();
            }
            else break;
        }
        return dq.size();
    }
}
