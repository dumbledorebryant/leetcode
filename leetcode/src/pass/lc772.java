package pass;
import java.util.*;
public class lc772 {
    int idx = 0;  // shared index to scan the input string (exactly once) between recursion calls
    public int calculate(String s) { // exact calc2 code, except two lines of logic added to handle '(' and ')'          
        int res = 0, pre = 0, num = 0, n = s.length();
        char sign = '+';
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == '(') num = calculate(s); // recursively calculate everything between '(' and ')'
            else if (c >= '0' && c <= '9') num = num * 10 + c - '0'; // handle numbers more than one digits
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || idx == n) { // different stop point for calculation
                switch (sign) {
                    case '+': res += pre; pre =  num; break;
                    case '-': res += pre; pre = -num; break;
                    case '*': pre *= num; break;
                    case '/': pre /= num; break;
                }
                if (c == ')') return res + pre; // finish and exit current level (recursive) processing
                num = 0;
                sign = c;
            }
        }
        return res + pre;
    }
}
class Solution {
    int i = 0;
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        int num = 0;
        char sign = '+';
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        while (i < length){
            char ch = chrs[i];
            i++;
            if (Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            if (ch == '('){
                num = calculate(s);
            }
            
            if ((!Character.isDigit(ch) && ch != ' ') || i == length){
                int pre;
                switch(sign){
                    case '+':{
                        stack.push(num);
                        break;
                    }
                    case '-':{
                        stack.push(-num);
                        break;
                    }
                    case '*':{
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    }
                    case '/':{
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                sign = ch;
                num = 0;
            }
            if (ch == ')'){
                break;
            }
        }
        sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
    
}