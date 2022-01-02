package pass;

public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        int num = root.val;
        if (val < num) root.left = insertIntoBST(root.left, val);
        if (val > num) root.right = insertIntoBST(root.right, val);
        return root;
    }
}
