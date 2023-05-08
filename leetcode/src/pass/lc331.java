package pass;

import java.util.*;

public class lc331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;
        Deque<Integer> dq = new ArrayDeque<>();
        String[] chrs = preorder.split(",");
        int length = chrs.length;
        for (int i = 0; i < length; i++){
            String ch = chrs[i];
            if (!ch.equals("#")){
                System.out.println(ch);
                dq.addLast(2);
            }
            else {
                System.out.println("null");
                if (dq.isEmpty()) return false;
                int last = dq.removeLast();
                last--;
                while (last == 0 && !dq.isEmpty()){
                    last = dq.removeLast();
                    last--;
                }
                if (last != 0) dq.addLast(last);
                if (dq.isEmpty() && i != length - 1) return false;
            }
            System.out.println(dq);
        }
        return dq.isEmpty();
    }
}
