package pass;

import java.util.*;
import pass.TreeNode;
public class lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> stack = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int level = 0;
        stack.add(root);
        map.put(root, level);

        int count = 1;
        int ncount = 0;
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode cur = stack.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left != null){
                stack.add(left);
                map.put(left, level);
                ncount++;
            }
            if (right != null){
                stack.add(right);
                map.put(right, level);
                ncount++;
            }
            list.add(cur.val);
            count--;
            if (count == 0){
                level++;
                ans.add(new ArrayList<>(list));
                list.clear();
                count = ncount;
                ncount = 0;
            }
        }
        return ans;
    }
}
