package pass;

import java.util.*;
import pass.TreeNode;
public class lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        int count = 1;
        int ncount = 0;
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode cur = stack.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left != null){
                stack.add(left);
                ncount++;
            }
            if (right != null){
                stack.add(right);
                ncount++;
            }
            list.add(cur.val);
            count--;
            if (count == 0){
                ans.add(new ArrayList<>(list));
                list.clear();
                count = ncount;
                ncount = 0;
            }
        }
        return ans;
    }
}
