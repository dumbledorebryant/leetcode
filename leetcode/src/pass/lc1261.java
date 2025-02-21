package pass;

import java.util.HashSet;
import java.util.Set;

public class lc1261 {
    Set<Integer> used = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        traverse(root);
    }

    public void traverse(TreeNode root){
        while (root != null){
            int val = root.val;
            used.add(val);
            TreeNode left = root.left;
            TreeNode right = root.right;
        
            if (left != null) {
                left.val = val * 2 + 1;
                traverse(left);
            }
            if (right != null){
                right.val = val * 2 + 2;
                traverse(right);
            }
            break;
        }
    }
    
    public boolean find(int target) {
        return used.contains(target);
    }
}
