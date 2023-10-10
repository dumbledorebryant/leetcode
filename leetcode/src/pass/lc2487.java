package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc2487 {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();

        while (head != null){
            while (!dq.isEmpty() && head.val > dq.getLast().val){
                dq.removeLast();
            }
            dq.addLast(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while (!dq.isEmpty()){
            ptr.next = dq.removeFirst();
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
