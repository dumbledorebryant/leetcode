package pass;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc2764 {
    public boolean isPreorder(List<List<Integer>> nodes) {
        // Check each seen node in a stack
        Deque<Integer> dq = new LinkedList<>();
        dq.add(nodes.get(0).get(0));
        for(int i=1; i<nodes.size(); i++) {
            List<Integer> node = nodes.get(i);
            int curr = node.get(0);
            int parent = node.get(1);
            while(!dq.isEmpty() && parent != dq.peekLast()) {
                dq.pollLast();

            }
            if(dq.isEmpty()) {
                return false;
            }
            dq.addLast(curr);
        }
        return true;
    }
}
