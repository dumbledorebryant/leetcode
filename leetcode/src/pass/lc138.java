package pass;

import java.util.*;

public class lc138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            Node ncur = new Node(cur.val);
            map.put(cur, ncur);
            cur = cur.next;
        }
        
        Node ptr = head;
        while (ptr != null){
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return map.get(head);
    }
}
