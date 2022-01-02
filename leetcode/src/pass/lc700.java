package pass;

public class lc700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        int num = root.val;
        if (num == val) return root;
        else if (num > val) return searchBST(root.left, val);
        else {
            return searchBST(root.right, val);
        }
    }
}
