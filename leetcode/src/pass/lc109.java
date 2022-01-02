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
        ListNode temp = head;
        TreeNode left = new TreeNode(temp.val);
        
        while(temp.next != slow){
            TreeNode tempp = new TreeNode(temp.next.val);
            tempp.left = left;
            left = tempp;
            temp = temp.next;
        }
        thead.left = left;

        thead.right = sortedListToBST(slow.next);
        return thead;
    }
}
