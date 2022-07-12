package pass;

import java.util.Deque;
import java.util.LinkedList;

public class lc117 {
    public Node connect(Node root) {
        Deque<Node> dq = new LinkedList<>();
        if (root == null) return null;
        dq.add(root);
        while (!dq.isEmpty()){
            int size = dq.size();
            Node dummy = new Node();
            for (int i = 0; i < size; i++){
                Node cur = dq.poll();
                Node left = cur.left;
                Node right = cur.right;
                if (left != null){
                    dq.add(left);
                }
                if (right != null){
                    dq.add(right);
                }
                dummy.next = cur;
                dummy = cur;
            } 
        }
        return root;
    }
}
