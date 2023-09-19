public class lc687 {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        path(root);
        return ans;
    }
    
    public int path(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        int num = root.val;
        int l = -1;
        if (left != null) l = path(left);
        int r = -1;
        if (right != null) r = path(right);
        if (l != -1 && num == left.val && r != -1 && num == right.val){
            ans = Math.max(ans, l + r + 2);
            return Math.max(l, r) + 1;
        } 
        if (l != -1 && num == left.val && (r == -1 || num != right.val)){
            ans = Math.max(ans, l + 1);
            return l + 1;
        }
        if (r != -1 && num == right.val && (l == -1 || num != left.val)){
            ans = Math.max(ans, r + 1);
            System.out.print(ans);
            return r + 1;
        }
        else return 0;
    }
}
