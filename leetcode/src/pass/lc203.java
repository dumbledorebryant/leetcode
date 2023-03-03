package pass;

public class lc203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        ListNode ans = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return ans;
        
    }
}
