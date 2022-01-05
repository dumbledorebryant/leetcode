package pass;

public class lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pos = head;
        ListNode ptr = head.next;
        while (ptr != null) {
            while (ptr != null && pos.val == ptr.val) {
                ptr = ptr.next;
            }
            pos.next = ptr;
            pos = pos.next;
            if (ptr != null) ptr = ptr.next;
            else break;
        }
        return head;
    }
}
