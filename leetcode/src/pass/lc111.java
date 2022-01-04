package pass;
import pass.TreeNode;
public class lc111 {
    int depth;
    int max;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        depth = 0;
        max = Integer.MAX_VALUE;
        backtrace(root);
        return max;
    }
    public void backtrace(TreeNode root){
        if (root == null) return;
        depth += 1;
        if (root.left == null && root.right == null) {
            max = Math.min(max, depth);
        }
        int cur = depth;
        if (root.left != null) {
            backtrace(root.left);
            depth = cur;
        }
        
        if (root.right != null) {
            backtrace(root.right);
            depth = cur;
        }
        
    }
}
