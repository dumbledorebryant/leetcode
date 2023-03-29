package pass;

import java.util.*;

public class lc369 {
    public ListNode plusOne(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp);
            temp = temp.next;
        }
        int size = list.size();
        int pre = 0;
        list.get(size - 1).val += 1;
        for (int i = size - 1; i >= 0; i--){
            ListNode cur = list.get(i);
            int num = cur.val;
            cur.val = (num + pre) % 10;
            pre = (num + pre) / 10;
        }
        if (pre == 1){
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            return newhead;
        }
        else return head;
    }
}
