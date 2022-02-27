package pass;

public class lc1381 {
    int[] stack;
    int ptr;
    public lc1381(int maxSize) {
        stack = new int[maxSize];
        ptr = -1;
    }
    
    public void push(int x) {
        if (ptr == stack.length - 1) {
            return;
        }
        ptr++;
        stack[ptr] = x;
    }
    
    public int pop() {
        if (ptr == -1) return -1;
        else {
            int num = stack[ptr];
            ptr--;
            return num;
        }
    }
    
    public void increment(int k, int val) {
        int len = Math.min(k, ptr + 1);
        for (int i = 0; i < len; i++){
            stack[i] += val;
        }
    }
}
