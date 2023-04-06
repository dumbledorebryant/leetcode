package pass;

public class lc156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode newLeft = upsideDownBinaryTree(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
