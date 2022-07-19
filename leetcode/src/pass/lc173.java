package pass;
import java.util.*;
import pass.TreeNode;
public class lc173 {
    int ptr = 0;
    List<TreeNode> iter = new ArrayList<>();
    public lc173(TreeNode root) {
        inorder(root);
    }
    public void inorder(TreeNode root){
        if (root == null) return;
        else {
            inorder(root.left);
            iter.add(root);
            inorder(root.right);
        }
    }
    
    public int next() {
        return iter.get(ptr++).val;
    }
    
    public boolean hasNext() {
        if (ptr == iter.size()) return false;
        else return true;
    }
}
