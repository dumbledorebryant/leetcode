package pass;
import pass.TreeNode;
public class lc114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tail = left;
        if (tail == null){
            return;
        }
        else {
            while (tail.right != null){
                tail = tail.right;
            }
            root.left = null;
            tail.right = root.right;
            root.right = left;
        }
    }
}
