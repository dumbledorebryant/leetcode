package pass;
public class lc814 {
    public TreeNode pruneTree(TreeNode root) {
        if (check(root)) return root;
        else return null;
    }

    public boolean check(TreeNode root){
        if (root == null) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root.val == 1) {
            if (!check(left)) root.left = null;
            if (!check(right)) root.right = null;
            return true;
        }
        else {
            boolean a = check(left);
            if (!a) root.left = null;
            boolean b = check(right);
            if (!b) root.right = null;
            if (!a && !b) return false;
            else return true;
        }
    }
}
