package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode r = new TreeNode(val);
            r.left = root;
            return r; 
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);

        while (!dq.isEmpty()){
            depth--;
            int size = dq.size();
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (depth == 1){
                    TreeNode l = new TreeNode(val);
                    TreeNode r = new TreeNode(val);
                    node.left = l;
                    node.right = r;
                    l.left = left;
                    r.right = right;
                }
                else {
                    if (left != null) dq.addLast(left);
                    if (right != null) dq.addLast(right);
                }
            }
            if (depth == 1) break;
        }
        return root;
    }
}
