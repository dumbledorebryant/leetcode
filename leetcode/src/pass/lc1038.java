package pass;

public class lc1038 {
    int presum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        int val = root.val;
        root.val = val + presum;
        presum += val;
        bstToGst(root.left);
        return root;
    }
}
