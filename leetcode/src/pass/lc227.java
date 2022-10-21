package pass;
import java.util.*;

public class lc227 {
    int index = 0;
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        
        char[] chrs = s.toCharArray();
        int length = s.length();

        int num = 0;
        char sign = '+';

        while (index < length) {
            char ch = chrs[index];
            index++;

            if (Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            if (ch == '('){
                num = calculate(s);
            }
            if (ch == ')'){
                break;
            }
            if ((!Character.isDigit(ch) && ch != ' ') || index == length){
                switch (sign){
                    case '+': {
                        stack.push(num);
                        break;
                    }

                    case '-': {
                        stack.push(-num);
                        break;
                    }

                    case '*': {
                        stack.push(stack.pop() * num);
                        break;
                    }

                    case '/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                sign = ch;
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

}
class Solution {
    int idx = 0;  // shared index to scan the input string (exactly once) between recursion calls
    public int calculate(String s) { // exact calc2 code, except two lines of logic added to handle '(' and ')'          
        int res = 0, pre = 0, num = 0, n = s.length();
        char sign = '+';
        while (idx < n) {
            char c = s.charAt(idx);
            idx++;
            if (c >= '0' && c <= '9') num = num * 10 + c - '0'; // handle numbers more than one digits
            if (c == '+' || c == '-' || c == '*' || c == '/' || idx == n) { // different stop point for calculation
                switch (sign) {
                    case '+': res += pre; pre =  num; break;
                    case '-': res += pre; pre = -num; break;
                    case '*': pre *= num; break;
                    case '/': pre /= num; break;
                }
                num = 0;
                sign = c;
            }
        }
        return res + pre;
    }
}