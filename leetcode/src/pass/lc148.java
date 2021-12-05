package pass;
import java.util.List;

import pass.ListNode;
public class lc148 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    public ListNode sort(ListNode head, ListNode tail){
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail){
                fast = fast.next;
            }
            else break;
        }
        int num = slow.val;
        ListNode left = sort(head, slow);
        ListNode right = sort(slow, tail);
        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        
        while (left != null && right != null){
            ListNode temp = new ListNode(0);
            if (left.val < right.val){
                temp.val = left.val;
                left = left.next;
            }
            else {
                temp.val = right.val;
                right = right.next;
            }
            ptr.next = temp;
            ptr = ptr.next;
        }
        if (left == null) ptr.next = right;
        if (right == null) ptr.next = left;
        return ans.next;
    }

    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node2.next = node1;
        node4.next = node2;
        System.out.println(sortList(node4));
    }
}
