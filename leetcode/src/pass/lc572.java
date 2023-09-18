package pass;

public class lc572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        int num = root.val;
        int snum = subRoot.val;
        if (num == snum){
            boolean ans = (check(root.left, subRoot.left) && check(root.right, subRoot.right));
            if (ans) return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null && root.val == subRoot.val) return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        return false;
    }
}
