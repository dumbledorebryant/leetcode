package pass;

public class lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = dummy.next;
        while (next != null){
            int val = next.val;
            if (next.next != null && val == next.next.val){
                while (next.next != null && val == next.next.val){
                    next = next.next;
                }
                next = next.next;
                prev.next = next;
            }
            else {
                prev.next = next;
                prev = prev.next;
                next = next.next;
            }
        }
        return dummy.next;
    }
}
