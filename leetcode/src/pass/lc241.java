package pass;
import java.util.*;
public class lc241 {
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chrs = expression.toCharArray();
        int length = chrs.length;
        return collect(chrs, 0, length - 1);
    }
    public List<Integer> collect(char[] chrs, int left, int right){
        List<Integer> ans = new ArrayList<>();
        if (left == right - 1) {
            int a = Character.getNumericValue(chrs[left]);
            int b = Character.getNumericValue(chrs[right]);
            ans.add(a * 10 + b);
            return ans;
        }
        if (left == right) {
            ans.add(Character.getNumericValue(chrs[left]));
            return ans;
        }
        for (int i = left + 1; i < right; i += 2){
            char oper = chrs[i];
            if (oper == '*' || oper == '+' || oper == '-'){
                List<Integer> leftnum = collect(chrs, left, i - 1);
                List<Integer> rightnum = collect(chrs, i + 1, right);
                for (int lnum : leftnum){
                    for (int rnum : rightnum) {
                        if (oper == '*')
                            ans.add(lnum * rnum);
                        if (oper == '+')
                            ans.add(lnum + rnum);
                        if (oper == '-')
                            ans.add(lnum - rnum);
                    }
                }
            }
        }
        return ans;
    }
}
