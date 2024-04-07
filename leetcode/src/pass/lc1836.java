package pass;

import java.util.HashMap;
import java.util.Map;

public class lc1836 {
    Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null){
            int num = p.val;
            if (map.containsKey(num)){
                map.put(num, -1);
            }
            else {
                map.put(num, 1);
            }
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode s = dummy;
        ListNode f = head;
        while(f != null){
            while (f != null && map.get(f.val) == -1){
                f = f.next;
            }
            s.next = f;
            s = s.next;
            if (f != null)  f = f.next;
        }
        return dummy.next;
}
