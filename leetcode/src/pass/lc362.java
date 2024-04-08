package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc362 {
    Deque<Integer> dq = new ArrayDeque<>();
  
    
    public void hit(int timestamp) {
        dq.addLast(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!dq.isEmpty() && timestamp - dq.peek() >= 300){
            dq.removeFirst();
        } 
        return dq.size();
    }
}
