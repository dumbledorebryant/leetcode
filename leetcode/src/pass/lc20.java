package pass;
import java.util.*;
import java.util.Stack;

public class lc20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (char ch : s.toCharArray()){
            if (stack.isEmpty()) {
                if (ch == '(' || ch == '{' || ch == '['){
                    stack.add(ch);
                }
                else return false;
            }
            else {
                char left = stack.peek();
                if (map.get(left) == ch) {
                    stack.pop();
                }
                else if (ch == '(' || ch == '{' || ch == '['){
                    stack.add(ch);
                }
                else return false;
            }
        }
        if (stack.isEmpty()) return true;
        
        else return false;
    }
}
