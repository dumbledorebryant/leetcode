package pass;

import java.util.*;

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++){
            if (b == null) return head;
            b = b.next;
        }
        ListNode nh = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return nh;
    }
    
    public ListNode reverse(ListNode a, ListNode b){
        ListNode nh = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b){
            next = cur.next;
            cur.next = nh;
            nh = cur;
            cur = next;
        }
        return nh;
    }

    public ListNode rvs(ListNode a){
        ListNode newhead = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != null){
            next = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = next;
        }
        return newhead;
    }    
}
