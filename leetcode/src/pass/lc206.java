package pass;

import java.util.*;

public class lc206 {
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        int length = list.size();
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        for (int i = 0; i < length; i++){
            tmp.next = list.get(length - 1 - i);
            tmp = tmp.next;
        }
        return ans.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode last = reverseList(head.next);
        if (last == null) return head;
        head.next.next = head; 
        head.next = null;
        return last;
    }

    public ListNode reverseIterative(ListNode head){
        if (head == null) return null;
        ListNode curh = head;
        ListNode ptr = head.next;
        ListNode next = head;
        curh.next = null;
        while (ptr != null){
            next = ptr.next;
            ptr.next = curh;
            curh = ptr;
            ptr = next;
        }
        return curh;
    }
}
