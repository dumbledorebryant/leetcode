package pass;
import pass.ListNode;
public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode end = head;
        int k = n;
        while (end != null && k > 0){
            end = end.next;
            k--;
        }
        
        while (end != null){
            end = end.next;
            cur = cur.next;
        }
        if (cur.next == null) return null;
        cur.next = cur.next.next;
        return head;
    }
}
