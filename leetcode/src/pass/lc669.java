package pass;

public class lc669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        int n = root.val;
        if (n < low) return trimBST(root.right, low, high);
        if (n > high) return trimBST(root.left, low, high);
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
