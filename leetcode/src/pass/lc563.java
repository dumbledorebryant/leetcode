package pass;

public class lc563 {
    int ans = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    public int sum(TreeNode root){
        if (root == null) return 0;
        int v = root.val;
        int l = sum(root.left);
        int r = sum(root.right);
        ans += Math.abs(l - r);
        return v + l + r;
    }
}
