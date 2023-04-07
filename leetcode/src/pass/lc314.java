package pass;
import java.util.*;
public class lc314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> cols = new LinkedList<>();
        int min = 0;
        int max = 0;
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            int col = cols.removeFirst();

            if (!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            int num = node.val;
            map.get(col).add(num);

            TreeNode left = node.left;
            if (left != null){
                queue.add(left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            TreeNode right = node.right;
            if (right != null){
                queue.add(right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}
