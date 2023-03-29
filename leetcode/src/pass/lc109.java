package pass;

import pass.TreeNode;

import java.util.List;

import pass.ListNode;
public class lc109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
            }
            else break;
        }

        TreeNode thead = new TreeNode(slow.val);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode next = head;
        while (next != null){
            if (next == slow){
                prev.next = null;
                break;
            }
            next = next.next;
            prev = prev.next;
        }

        thead.left = sortedListToBST(head);
        thead.right = sortedListToBST(slow.next);
        return thead;
    }
}
