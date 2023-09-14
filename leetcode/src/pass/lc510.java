package pass;

public class lc510 {
    public Node inorderSuccessor(Node node) {
        if (node == null) return null;
        Node parent = node.parent;
        if (node.right != null){
            Node right = node.right;
            while (right.left != null){
                right = right.left;
            } 
            return right;
        }
        if (parent == null){
            if (node.right == null) return null;
            Node right = node.right;
            while (right.left != null){
                right = right.left;
            } 
            return right;
        }
        if (parent.left == node) return parent;
        if (parent.right == node){
            if (node.right == null){
                while (parent != null && parent.right == node){
                    node = parent;
                    parent = parent.parent;
                }
                return parent;
            }
            else{
                Node right = node.right;
                while (right.left != null){
                    right = right.left;
                } 
                return right;
            }
        }
        return null;
    }
}
