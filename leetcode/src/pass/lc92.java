package pass;
import java.util.*;
import pass.ListNode;
public class lc92 {
    ListNode succ;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        if (left == 1)
            return reverseFromStart(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    
    public ListNode reverseFromStart(ListNode head, int len){
        if (len == 1) {
            succ = head.next;
            return head;
        } 
        ListNode next = reverseFromStart(head.next, len - 1);
        
        head.next.next = head;
        head.next = succ;
        return next;
    }
}
