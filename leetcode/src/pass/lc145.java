package pass;
import java.util.*;;
public class lc145 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        post(root);
        return ans;
    }
    public void post(TreeNode root){
        if (root == null) return;
        post(root.left);
        post(root.right);
        ans.add(root.val);
    }
}
