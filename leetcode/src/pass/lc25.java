package pass;

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        ListNode oldhead = head;
        ListNode succ;
        for (int i = 1; i < k; i++){
            newHead = newHead.next;
        }
        succ = newHead.next;
    }
    public ListNode reverseK(ListNode head, int k){
        
    }
}
