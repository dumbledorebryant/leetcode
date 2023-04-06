package pass;
import java.util.*;
public class lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.removeFirst();
                layer.add(cur.val);
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) queue.addLast(left);
                if (right != null) queue.addLast(right);
            }
            ans.add(layer);
        }
        Collections.reverse(ans);
        return ans;
    }
}
