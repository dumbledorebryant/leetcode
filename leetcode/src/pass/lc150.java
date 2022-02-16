package pass;

import java.util.*;

public class lc150 {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++){
            String str = tokens[i];
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int numb = stack.pop();
                int numa = stack.pop();
                switch(str){
                    case "+":{
                        stack.push(numa + numb);
                        break;
                    }
                    case "-":{
                        stack.push(numa - numb);
                        break;
                    }
                    case "*":{
                        stack.push(numa * numb);
                        break;
                    }
                    case "/":{
                        stack.push(numa / numb);
                        break;
                    }
                }
            }
            else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
