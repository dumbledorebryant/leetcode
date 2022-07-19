package pass;
import java.util.*;;
public class lc199 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return ans;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        while (!dq.isEmpty()){
            int size = dq.size();
            TreeNode edge = new TreeNode(0);
            for (int i = 0; i < size; i++){
                edge = dq.removeFirst();
                TreeNode left = edge.left;
                TreeNode right = edge.right;
                if (left != null) dq.add(left);
                if (right != null) dq.add(right);
            }
            ans.add(edge.val);
        }
        return ans;
    }
}
