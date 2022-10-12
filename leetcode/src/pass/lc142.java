package pass;
import java.util.HashMap;
import java.util.*;
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
    public ListNode dCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (b != null && b.next != null){
            a = a.next;
            b = b.next.next;
            if (a == b) {
                break;
            }
        }
        if (b == null || b.next == null) return null;
        a = head;
        while (a != b){
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
}
