package pass;

public class lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        ListNode tmp = head;
        while (tmp != null){
            len++;
            tmp = tmp.next;
        }
        k = k % len;
        if (k == 0) return head;
        for (int i = 0; i < k; i++){
            fast = fast.next;
            if (fast == null) return head;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        fast.next = head;
        return newhead;
    }
}
