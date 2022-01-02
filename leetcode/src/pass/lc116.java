package pass;
import pass.Node;
public class lc116 {
    public Node connect(Node root) {
        if (root == null) return null;
        connected(root.left, root.right);
        return root;
    }

    public void connected(Node node1, Node node2){
        if (node1 == null){
            return;
        }
        if (node2 == null){
            return;
        }
        node1.next = node2;
        connected(node1.left, node1.right);
        connected(node2.left, node2.right);
        connected(node1.right, node2.left);
    }
}
