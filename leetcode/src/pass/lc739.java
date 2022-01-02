package pass;

import java.util.Stack;

public class lc739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> s = new Stack<>();
        for (int i = len - 1; i >= 0; i--){
            while(!s.empty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            ans[i] = s.empty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return ans;
    }
}
