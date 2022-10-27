package pass;
import java.util.*;
public class lc144 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }
    public void preorder(TreeNode root){
        if (root == null) return;
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
