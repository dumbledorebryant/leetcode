package pass;

import java.util.*;

public class lc138 {
    public Node copyRandomList(Node head) {
        Node ohead = head;
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node nhead = dummy;
        Node ans = dummy;
        while (head != null){
            dummy.next = new Node(head.val);
            dummy = dummy.next;
            Node temp = dummy;
            while (temp.left)
        }
        
    }
}
