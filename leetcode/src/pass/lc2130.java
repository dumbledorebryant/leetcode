package pass;

public class lc2130 {
    public int pairSum(ListNode head) {
        if (head == null) return 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rvs = reverse(slow);
        ListNode ptr = head;
        int max = 0;
        while (rvs != null){
            max = Math.max(max, rvs.val + ptr.val);
            rvs = rvs.next;
            ptr = ptr.next;
        }
        return max;
    }
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode ptr = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ptr;
    }
}
