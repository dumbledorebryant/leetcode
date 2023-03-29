package pass;

import java.util.PriorityQueue;

public class lc148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode temp = head;
        while (temp != null){
            queue.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode next = dummy;
        while (!queue.isEmpty()){
            ListNode cur = new ListNode(queue.poll());
            next.next = cur;
            next = next.next;
        }
        return dummy.next;
    }
}
