package pass;

public class lc24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        cur = cur.next; 
        cur = cur.next;
        ListNode ptr = head;
        ListNode newhead = ptr.next;
        newhead.next = ptr;
        ptr.next = swapPairs(cur);
        return newhead;
    }
}
