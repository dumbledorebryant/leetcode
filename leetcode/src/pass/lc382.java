package pass;
import java.util.*;

import pass.ListNode;
public class lc382 {
    List<Integer> list;
    public lc382(ListNode head) {
        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random r = new Random();
        int length = list.size();
        int pick = r.nextInt(length);
        return list.get(pick);
    }
}
