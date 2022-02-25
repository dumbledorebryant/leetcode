package pass;

public class lc237 {
    public void deleteNode(ListNode node) {
        ListNode tmp = node;
        while (node.next != null){
            node.val = node.next.val;
            tmp = node;
            node = node.next;
        }
        tmp.next = null;
    }
}
