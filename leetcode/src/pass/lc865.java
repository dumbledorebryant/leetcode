package pass;

public class lc865 {
    int max = 0;
    TreeNode ans = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        postOrder(root, 0);
        return ans;
    }

    public int postOrder(TreeNode root, int d){
        if (root == null) return d;
        int left = postOrder(root.left, d + 1);
        int right = postOrder(root.right, d + 1);
        int cur = Math.max(left, right);
        max = Math.max(max, cur);
        if (left == max && right == max){
            ans = root;
        }
        return cur;
    }
}
