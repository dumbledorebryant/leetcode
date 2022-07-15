package pass;
import java.util.*;;
import pass.ListNode;

public class lc143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode comb = head;
        ListNode tmp = head;
        Deque<ListNode> dq = new LinkedList<>();
        int count = 0;
        while (tmp != null){
            dq.add(new ListNode(tmp.val));
            tmp = tmp.next;
            count++;
        }
        int half = count / 2;
        ListNode dummy = new ListNode(0);
        ListNode back = dummy;
        while (half > 0){
            dummy.next = dq.removeLast();
            dummy = dummy.next;
            half--;
        }
        back = back.next;
        while (back != null){
            System.out.println(comb.val);
            System.out.println(back.val);
            ListNode anext = comb.next;
            ListNode bnext = back.next;
            comb.next = back;
            back.next = anext;
            back = bnext;
            comb = anext;
        }
        ListNode tail = head;
        while (count > 1){
            tail = tail.next;
            count--;
        }
        tail.next = null;
    }
}
