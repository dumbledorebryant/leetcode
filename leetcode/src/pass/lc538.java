package pass;

public class lc538 {
    int presum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        int val = root.val;
        root.val = val + presum;
        presum += val;
        convertBST(root.left);
        return root;
    }
}
