package pass;

public class lc129 {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int num){
        num = num * 10 + root.val;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l == null && r == null) {
            ans += num;
            return;
        }
        if (l != null) dfs(root.left, num);
        if (r != null) dfs(root.right, num);
    }
}
