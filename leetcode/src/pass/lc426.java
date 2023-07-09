package pass;

public class lc426 {
    Node first =null, last=null;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        treeToDoublyList(root.left);
        if(last!=null){
            last.right=root;
            root.left=last;
        }else first=root;
        last=root;
        treeToDoublyList(root.right);
        last.right=first;
        first.left=last;
        return first;
    }
}
