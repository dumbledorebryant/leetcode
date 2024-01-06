package pass;

public class lc951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2 == null;
        if (root2 == null) return root1 == null;
        if (root1.val != root2.val) return false;
        boolean nfe = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if (nfe) return true;
        boolean fe = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        if (fe) return true;
        return false;
    }
}
