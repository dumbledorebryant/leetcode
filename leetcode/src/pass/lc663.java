package pass;

public class lc663 {
    TreeNode head;
    public boolean checkEqualTree(TreeNode root) {
        head = root;
        int sum = addSum(root);
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return find(root, target);
    }

    public int addSum(TreeNode root){
        if (root == null) return 0;
        int val = root.val;
        int left = addSum(root.left);
        int right = addSum(root.right);
        root.val = val + left + right;
        return root.val;
    }

    public boolean find(TreeNode root, int k){
        if (root == null) return false;
        if (root.val == k && head != root) return true;
        return find(root.left, k) || find(root.right, k);
    }
}
