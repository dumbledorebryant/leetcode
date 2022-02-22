package pass;

public class lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean flag = findson(root, p) && findson(root, q);
        if (flag == false) return null;
        
        TreeNode ln = lowestCommonAncestor(root.left, p, q);
        if (ln != null) return ln; 
        TreeNode rn = lowestCommonAncestor(root.right, p, q);
        if (rn != null) return rn;
        return root;        
    }
    public boolean findson(TreeNode root, TreeNode son){
        if (root == null) return false;
        if (root == son) return true;
        else {
            return findson(root.left, son) || findson(root.right, son);
        }
    }
}
