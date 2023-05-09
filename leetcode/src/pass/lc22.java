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

    List<String> anss = new ArrayList<>();
    public List<String> generateP(int n) {
        if (n == 0) return anss;
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        backtrace(n - 1, n, sb);
        return ans;
    }

    private void backtrace(int left, int right, StringBuilder sb){
        if (left < 0 || right < 0) return;
        if (left > right) return;
        if (left == 0 && right == 0) {
            anss.add(sb.toString());
            return;
        }
        sb.append('(');
        backtrace(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        backtrace(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
