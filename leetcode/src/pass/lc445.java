package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        while (l1 != null){
            s1.addLast(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.addLast(l2.val);
            l2 = l2.next;
        }

        int pre = 0;
        ListNode dummy = new ListNode(-1);
        while (!s1.isEmpty() || !s2.isEmpty()){
            int num1 = 0;
            int num2 = 0;
            if (!s1.isEmpty()) num1 = s1.removeLast();
            if (!s2.isEmpty()) num2 = s2.removeLast();
            int cur = num1 + num2 + pre;
            if (cur >= 10){
                cur %= 10;
                pre = 1;
            }
            else pre = 0;
            ListNode tmp = new ListNode(cur);
            ListNode next = dummy.next;
            tmp.next = next;
            dummy.next = tmp;
        }
        if (pre == 1){
            ListNode head = new ListNode(1);
            head.next = dummy.next;
            dummy.next = head;
        }

        return dummy.next;
    }
}
