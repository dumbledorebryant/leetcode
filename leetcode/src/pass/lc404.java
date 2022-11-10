package pass;

public class lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int lvalue = sumOfLeftLeaves(root.left);
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null)
        {
            lvalue = left.val;
        }
        int rvalue = sumOfLeftLeaves(root.right);
        return lvalue + rvalue;
    }
}
