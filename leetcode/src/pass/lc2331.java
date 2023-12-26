package pass;

public class lc2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return true;
        int num = root.val;
        if (num == 0) return false;
        if (num == 1) return true;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (num == 2) return left || right;
        else return left && right;
    }
}
