package pass;

import java.util.*;

public class lc277 {
    public boolean knows(int a, int b){return true;}

    public int findCelebrity(int n) {
        if (n == 1) return 0;

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            queue.addLast(i);
        }

        while (queue.size() >= 2){
            int cand = queue.removeFirst();
            int other = queue.removeFirst();
            if (knows(cand, other) || !knows(other, cand)){
                queue.addFirst(other);
            }
            else {
                queue.addFirst(cand);
            }
        }
        int cand = queue.removeFirst();
        for (int i = 0; i < n; i++){
            if (cand == i) continue;
            if (knows(cand, i) || !knows(i, cand)) return -1;
        }
        return cand;
    }
}
