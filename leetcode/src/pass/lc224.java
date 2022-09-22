package pass;
import java.util.*;

public class lc224 {
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
