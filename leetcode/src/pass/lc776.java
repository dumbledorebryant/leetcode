package pass;
public class lc776 {
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] ans = new TreeNode[2];
        if (root == null) return ans;
        int num = root.val;
        if (num == target){
            ans[0] = root;
            ans[1] = root.right;
            root.right = null;
        }
        else if (num > target){
            TreeNode[] ls = splitBST(root.left, target);
            root.left = ls[1];
            ans[0] = ls[0];
            ans[1] = root;
        }
        else{
            
            TreeNode[] rs = splitBST(root.right, target);
            root.right = rs[0];
            ans[1] = rs[1];
            ans[0] = root;
            
        }
        return ans;
    }
}
