package pass;

import java.util.*;

public class lc513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        TreeNode lnode = null;
        while (!dq.isEmpty()){
            int size = dq.size();            
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                if (i == 0) lnode = node;
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    dq.addLast(left);
                }
                if (right != null) {
                    dq.addLast(right);
                }
            }
            
        }
        if (lnode != null) return lnode.val;
        return -1;
    }
}
