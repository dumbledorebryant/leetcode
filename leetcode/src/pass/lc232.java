package pass;

import java.util.Stack;

public class lc232 {
    Stack<Integer> prev = new Stack<>();
    Stack<Integer> next = new Stack<>();
    public lc232() {
        
    }
    
    public void push(int x) {
        prev.push(x);
    }
    
    public int pop() {
        while (!prev.isEmpty()){
            next.push(prev.pop());
        }
        int num = next.pop();
        while (!next.isEmpty()){
            prev.push(next.pop());
        }
        return num;
    }
    
    public int peek() {
        while (!prev.isEmpty()){
            next.push(prev.pop());
        }
        int num = next.peek();
        while (!next.isEmpty()){
            prev.push(next.pop());
        }
        return num;
    }
    
    public boolean empty() {
        return prev.isEmpty();
    }
}
