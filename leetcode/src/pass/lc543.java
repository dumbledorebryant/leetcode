package pass;
import java.util.*;
import pass.TreeNode;
public class lc543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int dia = l + r;
        max = Math.max(max, dia);
        return 1 + Math.max(l, r);
    }

    int ans = 0;
    public int diameterOfBinTree(TreeNode root) {
        md(root);
        return ans;
    }
    public int md(TreeNode root){
        if (root == null) return 0;
        int l = md(root.left);
        int r = md(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}
