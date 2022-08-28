package pass.weekly_contest.wc2022_08_27;

import java.util.Stack;

public class lc6161 {
    public String removeStars(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            if (ch != '*'){
                stack.add(ch);
            }
            else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
