package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc346 {
    Deque<Integer> dq = new ArrayDeque<>();
    int sum = 0;
    int sz;
    public lc346(int size) {
        sz = size;
    }
    
    public double next(int val) {
        sum += val;
        dq.addLast(val);
        if (dq.size() > sz){
            sum -= dq.removeFirst();
            return sum * 1.0 / sz;
        }
        else {
            return sum * 1.0 / dq.size();
        }
    }
}
