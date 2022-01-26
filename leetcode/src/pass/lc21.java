package pass;
import pass.ListNode;
import java.util.*;
public class lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null && list2 != null){
            cur.next = list2;
        }
        if (list2 == null && list1 != null){
            cur.next = list1;
        }
        return head.next;
    }
}
