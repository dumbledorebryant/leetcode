package pass.weekly_contest.wc2022_02_19;
import pass.ListNode;
public class lc6013 {
    public ListNode mergeNodes(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int count = 0;
        while (cur != null){
            if (cur.val != 0){
                count += cur.val;
            }
            else {
                tmp.next = new ListNode(count);
                tmp = tmp.next;
                count = 0;
            }
            cur = cur.next;
        }
        return ans.next.next;
    }
}
