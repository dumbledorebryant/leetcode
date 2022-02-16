package pass;

import java.util.Stack;

public class lc155 {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public lc155() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty()) minstack.push(val);
        else 
            minstack.push(Math.min(val, minstack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
