package pass;
import pass.TreeNode;
public class lc112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (targetSum < 0) return false;
        int num = root.val;
        if (root.left == null && root.right == null && targetSum == num) return true;
        return hasPathSum(root.left, targetSum - num) || hasPathSum(root.right, targetSum - num);
    }
}
