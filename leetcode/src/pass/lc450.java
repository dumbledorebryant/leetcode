package pass;

public class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        int num = root.val;
        if (key < num) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > num) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode min = getMin(root.right);
            int minv = min.val;
            root.val = minv;
            root.right = deleteNode(root.right, minv);
        }
        return root;
    }
    public TreeNode getMin(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}

