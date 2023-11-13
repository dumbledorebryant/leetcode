package pass;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc2641 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        int depth = 0;
        while (!dq.isEmpty()){
            int size = dq.size();
            int sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                sum += node.val;
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    dq.addLast(left);
                }
                if (right != null) {
                    dq.addLast(right);
                }
            }
            
            map.put(depth, sum);
            depth++;
        }

        root.val = 0;
        dq.addLast(root);
        depth = 1;
        while (!dq.isEmpty()){
            int size = dq.size();
            int sum = 0;
            
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                TreeNode left = node.left;
                TreeNode right = node.right;
                int cur = 0;
                if (left != null) {
                    cur += left.val;
                }
                if (right != null) {
                    cur += right.val;
                }
                System.out.println(cur + " " + map.get(depth));
                if (left != null) {
                    left.val = map.get(depth) - cur;
                    dq.addLast(left);
                }
                if (right != null) {
                    right.val = map.get(depth) - cur;
                    dq.addLast(right);
                }
            }
            map.put(depth, sum);
            depth++;
        }
        return root;
    }
}
