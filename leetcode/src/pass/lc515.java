package pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);   
        while (!dq.isEmpty()){
            int size = dq.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                max = Math.max(max, node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) dq.addLast(left);
                if (right != null) dq.addLast(right);
            }
            if (size != 0) ans.add(max);
        }
        return ans;
    }
}
