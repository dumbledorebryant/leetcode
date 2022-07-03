package pass;

import pass.TreeNode;

public class lc110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (heights(root) != -1) return true;
        else return false;
    }
    public int heights(TreeNode root){
        if (root == null) return 0;
        int left = heights(root.left);
        if (left == -1) return -1;
        int right = heights(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
