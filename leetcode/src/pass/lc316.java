package pass;
import java.util.*;

import javax.swing.Popup;

public class lc316 {
    public String removeDuplicateLetters(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chrs){
            map.put(ch, 1 + map.getOrDefault(ch, 0));
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int index = 1;
        while (!stack.isEmpty() && index < length){
            char ch = chrs[index];
            int topind = stack.peek();
            char top = chrs[topind];
            if (ch < top){
                // not duplicated
                if (map.get(top) == 1){
                    // keep it
                    stack.add(index);
                    index++;
                    map.put(top, map.get(ch) - 1);
                }
                else stack.pop();
                if (stack.isEmpty()){
                    stack.add(index);
                    index++;
                }
            }
            else {
                stack.add(index);
                index++;
            }
        }
        String ans = "";
        while (!stack.isEmpty()){
            int ind = stack.pop();
            ans += String.valueOf(s.substring(ind, ind + 1));
        }
        return ans;
    }
}
