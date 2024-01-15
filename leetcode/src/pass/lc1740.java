package pass;

public class lc1740 {
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        TreeNode node = findlca(root, p, q);
        int val = node.val;
        if (val != p && val != q){
            return find(node, p) + find(node, q);
        }
        else {
            return val == p ? find(node, q) : find(node, p);
        }
    }

    public TreeNode findlca(TreeNode root, int p, int q){
        if (root == null) return null;
        int val = root.val;
        if (val == p || val == q){
            return root;
        }
        TreeNode left = findlca(root.left, p, q);
        TreeNode right = findlca(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        else return root;
    }

    public int find(TreeNode root, int num){
        if (root == null) return -1;
        int val = root.val;
        if (num == val){
            return 0;
        }
        int left = find(root.left, num);
        int right = find(root.right, num);
        if (left != -1){
            return 1 + left;
        }
        if (right != -1){
            return 1 + right;
        }
        return -1;
    }
}
