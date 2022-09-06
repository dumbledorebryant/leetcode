package pass;
import java.util.*;
public class lc86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode lptr = large;
        ListNode sptr = small;
        while (head != null){
            if (head.val < x){
                sptr.next = head;
                sptr = sptr.next;
            }
            else {
                lptr.next = head;
                lptr = lptr.next;
            }
            head = head.next;
        }
        sptr.next = large.next;
        lptr.next = null;
        return small.next;
    }   
}
