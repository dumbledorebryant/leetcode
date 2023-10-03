package pass;

public class lc1026 {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, -100001, 100001);
        return ans;
    }

    public void dfs(TreeNode root, int max, int min){
        if (root == null) return;
        int num = root.val;
        if (num > max) max = num;
        if (num < min) min = num;
        ans = Math.max(ans, max - min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
