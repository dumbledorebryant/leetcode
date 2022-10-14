package pass;

public class lc606 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        help(root);
        return sb.toString();
    }
    public void help(TreeNode root){
        if (root == null) return;
        sb.append(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) return;
        sb.append("(");
        if (left != null){
            help(left);
        }
        sb.append(")");
        if (right != null){
            sb.append("(");
            help(right);
            sb.append(")");
        }
    }
}
