package pass;

public class lc671 {
    long one = Long.MAX_VALUE - 2;
    long two = Long.MAX_VALUE - 1;
    public int findSecondMinimumValue(TreeNode root) {
        check(root);
        if (two <= Integer.MAX_VALUE) return (int)two;
        return -1;
    }

    public void check(TreeNode root){
        if (root == null) return;
        int val = root.val;
        if (val < one){
            two = one;
            one = val;
        }
        else if (val > one && val < two){
            two = val;
        }
        check(root.left);
        check(root.right);
    }
}
