package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> dq = new ArrayDeque<>();
        int pre = 0;
        int ans = 0;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                dq.addLast(ans);
                ans = 0;
            }
            else {
                ans = dq.removeLast() + Math.max(2 * ans, 1);
            }
        }
        return ans;
    }
}
