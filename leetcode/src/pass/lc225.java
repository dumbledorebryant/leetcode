package pass;

import java.util.PriorityQueue;

import java.util.*;

public class lc225 {
    Queue<Integer> prev = new PriorityQueue<>();
    Queue<Integer> next = new PriorityQueue<>();
    public lc225() {
        
    }
    
    public void push(int x) {
        prev.add(x);
    }
    
    public int pop() {
        int num = 0;
        while (!prev.isEmpty()){
            num = prev.poll();
            if (prev.isEmpty()) break;
            else next.add(num);
        }
        while (!next.isEmpty()){
            prev.add(next.poll());
        }
        return num;
    }
    
    public int top() {
        int num = 0;
        while (!prev.isEmpty()){
            num = prev.poll();
            next.add(num);
        }
        while (!next.isEmpty()){
            prev.add(next.poll());
        }
        return num;
    }
    
    public boolean empty() {
        return prev.isEmpty();
    }
}
