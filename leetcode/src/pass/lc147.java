package pass;
import pass.ListNode;
import java.util.*;

public class lc147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-5001);
        dummy.next = head;
        head = head.next;
        dummy.next.next = null;
        while (head != null){
            ListNode tmp = dummy;
            ListNode cur = head;
            head = head.next;
            cur.next = null;
            while (tmp.next != null){
                int cur_num = cur.val;
                int num = tmp.next.val;
                if (cur_num > num){
                    tmp = tmp.next;
                }
                else {
                    ListNode next = tmp.next;
                    tmp.next = cur;
                    cur.next = next;
                    break;
                }
            } 
            if (tmp.next == null){
                tmp.next = cur;
                cur.next = null;
            }
        }
        return dummy.next;
    }
}
