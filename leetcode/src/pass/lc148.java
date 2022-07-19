package pass;
public class lc148 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    public ListNode sort(ListNode head, ListNode tail){
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail){
                fast = fast.next;
            }
            else break;
        }

        ListNode left = sort(head, slow);
        ListNode right = sort(slow.next, tail);
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
}
