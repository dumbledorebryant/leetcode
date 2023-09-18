package pass;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc662 {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        int ans = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        while (!dq.isEmpty()){
            int size = dq.size();
            int start = map.get(dq.getFirst());
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                int idx = map.get(node);
                if (i == size - 1) ans = Math.max(ans, idx - start + 1);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null){
                    dq.addLast(left);
                    map.put(left, idx * 2);
                }
                if (right != null){
                   map.put(right, idx * 2 + 1);
                   dq.addLast(right);
                }
            }
        }
        return ans;
    }
}
