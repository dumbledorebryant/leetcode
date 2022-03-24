package pass;

public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode ohead = odd;
        ListNode even = new ListNode(0);
        ListNode ehead = even;
        ListNode ptr = head;
        int count = 1;
        while (ptr != null){
            if (count % 2 == 1){
                odd.next = ptr;
                odd = odd.next;
            }
            else {
                even.next = ptr;
                even = even.next;
            }
            ListNode temp = ptr.next;
            ptr.next = null;
            ptr = temp;
            count++;
        }
        odd.next = ehead.next;
        return ohead.next;
    }
}
