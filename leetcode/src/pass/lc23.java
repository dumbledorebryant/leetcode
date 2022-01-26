package pass;

import java.util.*;

public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists){
            if (list != null)
                queue.add(list);
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (!queue.isEmpty()){
            ListNode minn = queue.poll();
            cur.next = minn;
            if (minn.next != null) queue.offer(minn.next);
            cur = cur.next;
        }
        return dummyHead.next;
    }
    
}
