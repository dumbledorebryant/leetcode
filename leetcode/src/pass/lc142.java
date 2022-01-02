package pass;
import java.util.HashMap;
import java.util.*;
import pass.ListNode;
public class lc142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        ListNode list = head;

        Map<ListNode, Integer> map = new HashMap<>();
        map.put(list, 1);
        list = list.next;
        while(list != null){
            if (map.getOrDefault(list, 0) != 0) return list;
            else map.put(list, 1);
            list = list.next;
        }
        return null;
    }
}
