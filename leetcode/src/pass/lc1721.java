package pass;

public class lc1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode f = null;
        ListNode e = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        f = fast;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        e = slow;
        System.out.println(e.val);
        ListNode a = f.next;
        ListNode b = e.next;
        ListNode tmp = b.next;
        if (a.next == b) {
            f.next = b;
            b.next = a;
            a.next = tmp;
        } else if (b.next == a){
            tmp = a.next;
            e.next = b;
            a.next = b;
            b.next = tmp;
        } else{
            f.next = b;
            b.next = a.next;
            e.next = a;
            a.next = tmp;
        }

        return dummy.next;
    }
}
