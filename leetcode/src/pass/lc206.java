package pass;

import java.util.*;

public class lc206 {
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        int length = list.size();
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        for (int i = 0; i < length; i++){
            tmp.next = list.get(length - 1 - i);
            tmp = tmp.next;
        }
        return ans.next;
    }
}
