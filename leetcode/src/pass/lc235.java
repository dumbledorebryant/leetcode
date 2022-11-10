package pass;

public class lc235 {
    int a = 0;
    int b = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        a = p.val;
        b = q.val;
        if (a > b){
            lowestCommonAncestor(root, q, p);
        }
        if (root == null) return null;
        int num = root.val;
        if (num <= b && num >= a) return root;
        if (num > b) return lowestCommonAncestor(root.left, p, q);
        if (num < a) return lowestCommonAncestor(root.right, p, q);
        return null; 
    }
}
