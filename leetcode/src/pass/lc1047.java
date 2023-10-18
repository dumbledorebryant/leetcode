package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1047 {
    public String removeDuplicates(String s) {
        char[] chrs = s.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();

        for (char ch : chrs){
            if (!dq.isEmpty() && dq.getLast() == ch){
                dq.removeLast();
            }
            else{
                dq.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.removeFirst());
        }
        return sb.toString();
    }
}
