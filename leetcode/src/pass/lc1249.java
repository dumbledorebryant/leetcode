package pass;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] chrs = s.toCharArray();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            char ch = chrs[i];
            if (ch == '('){
                dq.addLast(i);
            }
            if (ch == ')'){
                if (dq.isEmpty()) dq.addLast(i);
                else if (chrs[dq.getLast()] == '('){
                    dq.removeLast();
                }
                else {
                    dq.addLast(i);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        while (!dq.isEmpty()){
            set.add(dq.removeFirst());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (!set.contains(i)) sb.append(chrs[i]);
        }
        return sb.toString();
    }
}
