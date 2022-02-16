package pass;

public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dA = headA;
        ListNode dB = headB;
        
        while (dA != dB){
            dA = dA == null ? headB : dA.next;
            dB = dB == null ? headA : dB.next;
        }
        
        return dB;
    }
}
