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
