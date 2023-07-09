package pass;

public class lc298 {
    int ans = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 1;
        lc(root, root.left, 1);
        lc(root, root.right, 1);
        return ans;
    }
    public void lc(TreeNode parent, TreeNode root, int cur){
        if (root == null) return;
        int p = parent.val;
        int r = root.val;
        if (r - p == 1){
            cur++;
            ans = Math.max(ans, cur);
            lc(root, root.left, cur);
            lc(root, root.right, cur);
        }
        else {
            lc(root, root.left, 1);
            lc(root, root.right, 1);
        }
    }
}
