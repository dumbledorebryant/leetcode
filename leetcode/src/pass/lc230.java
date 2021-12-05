package pass;

import java.util.*;

public class lc230 {
    int num;
    int value;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        inorder(root);
        return value;
    }
    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        num--;
        if (num == 0) value = root.val;
        inorder(root.right);
    }
}
