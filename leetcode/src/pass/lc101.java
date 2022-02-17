package pass;

public class lc101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return comp(root.left, root.right);
    }
    public boolean comp(TreeNode left, TreeNode right){
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left == right) {
            return comp(left.left, right.right) 
                && comp(left.right, right.left);
        }
        else return false;
    }
}
