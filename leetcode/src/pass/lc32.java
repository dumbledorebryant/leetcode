package pass;

import java.util.*;

public class lc32 {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        int ans = 0;
        for (int i = 0; i < n; i++){
            char ch = cs[i];
            if (ch == '(') stack.addLast(i);
            else {
                stack.removeLast();
                if (stack.isEmpty()){
                    stack.addLast(i);
                }
                else {
                    ans = Math.max(ans, i - stack.getLast());
                }
            }
        }
        return ans;
    }
}
