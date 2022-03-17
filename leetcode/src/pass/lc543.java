package pass;
import java.util.*;
import pass.TreeNode;
public class lc543 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = dia(root);
        return max;
    }
    public int[] dia(TreeNode root){
        if (root == null) return new int[2];
        int[] left = dia(root.left);
        int[] right = dia(root.right);
        int[] ans = new int[2];
        ans[0] = left[0] + right[0] + 2;
        max = Math.max(max, ans[0]);
        ans[1] = Math.max(left[1], right[1]) + 1;
        return ans;
    }
}
