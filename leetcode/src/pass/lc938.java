package pass;

public class lc938 {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int num = root.val;
        if (num >= low && num <= high){
            int ans = num;
            ans += rangeSumBST(root.left, low, high);
            ans += rangeSumBST(root.right, low, high);
            return ans;
        }
        
        if (num > high){
            return rangeSumBST(root.left, low, high);
        }
        if (num < low){
            return rangeSumBST(root.right, low, high);
        }
        return 0;
    }
}
