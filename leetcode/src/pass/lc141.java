package pass;
import java.util.HashSet;

import pass.ListNode;
import java.util.*;
public class lc141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hset = new HashSet<>();
        while (head != null){
            if (hset.contains(head)) return true;
            hset.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (b != null && b.next != null){
            a = a.next;
            b = b.next.next;
            if (a == b) return true;
        }
        return false;
    }
}
