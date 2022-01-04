package pass;

import java.util.*;

public class lc22 {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        if (n == 0) return ans;
        String str = "(";
        backtrace(n - 1, n, str);
        return ans;
    }
    public void backtrace(int left, int right, String str){
        if (left < 0 || right < 0) return;
        if (right < left) return;
        if (left == 0 && right ==0) {
            ans.add(str);
            return;
        }

        str += '(';
        backtrace(left - 1, right, str);
        str = str.substring(0, str.length() - 1);
        str += ')';
        backtrace(left, right - 1, str);
        str = str.substring(0, str.length() - 1);
    }
}
