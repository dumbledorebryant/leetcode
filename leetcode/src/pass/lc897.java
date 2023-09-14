package pass;

public class lc897 {
    TreeNode pre = new TreeNode(-1);
    TreeNode cur = pre;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        increasingBST(root.left);
        cur.right = root;
        root.left = null;
        cur = cur.right;
        increasingBST(root.right);
        return pre.right;
    }
}
