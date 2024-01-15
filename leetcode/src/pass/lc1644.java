package pass;

public class lc1644 {
    boolean l = false;
    boolean r = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = find(root, p, q);
        if (l && r) return node;
        return null;
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        int val = root.val;
        if (root == p){
            l = true;
            return root;
        }
        if (root == q){
            r = true;
            return root;
        }
        
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
