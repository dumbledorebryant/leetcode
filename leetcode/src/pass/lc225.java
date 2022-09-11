package pass;

import java.util.*;

public class lc225 {
    Queue<Integer> queue = new LinkedList<>();
    int ele;
    public lc225() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
        ele = x;
    }
    
    public int pop() {
        int size = queue.size();
        while (size > 2){
            queue.offer(queue.poll());
        }
        ele = queue.poll();
        queue.offer(ele);
        return queue.poll();
    }
    
    public int top() {
        return ele;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
