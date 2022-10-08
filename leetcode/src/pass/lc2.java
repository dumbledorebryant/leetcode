package pass;

import java.util.*;

public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> a = new ArrayDeque<>();
        Deque<Integer> b = new ArrayDeque<>();
        while (l1 != null){
            a.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            b.add(l2.val);
            l2 = l2.next;
        }
        int la = a.size();
        int lb = b.size();
        int min = Math.min(la, lb);
        Deque<Integer> list = new ArrayDeque<>();
        int flag = 0;
        for (int i = 0; i < min; i++){
            int numa = a.pop();
            int numb = b.pop();
            list.add((numa + numb + flag) % 10);
            flag = (numa + numb + flag) / 10;
        }
        if (la > lb){
            while (!a.isEmpty()){
                int num = a.pop();
                list.add((num + flag) % 10);
                flag = (num + flag) / 10;
            }
        }
        else {
            while (!b.isEmpty()){
                int num = b.pop();
                list.add((num + flag) % 10);
                flag = (num + flag) / 10;
            }
        }
        if (flag == 1) list.add(1);
        ListNode head = new ListNode();
        ListNode ptr = head;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--){
            int num = list.pop();
            ListNode tmp = new ListNode(num);
            ptr.next = tmp;
            ptr = ptr.next;
        }
        return head.next;
    }
}
