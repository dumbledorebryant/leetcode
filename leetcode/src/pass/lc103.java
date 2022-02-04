package pass;

import java.util.*;
import pass.TreeNode;
public class lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty() || !queue.isEmpty()){
            while (!stack.isEmpty()){
                TreeNode cur = stack.pop();
                TreeNode left = cur.left;
                TreeNode right = cur.right;

                if (right != null){
                    queue.add(right);
                }
                if (left != null){
                    queue.add(left);
                }
                list.add(cur.val);
            }
            if (!list.isEmpty()) ans.add(new ArrayList<>(list));
            list.clear();
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                TreeNode left = cur.left;
                TreeNode right = cur.right;

                if (right != null){
                    stack.add(right);
                }
                if (left != null){
                    stack.add(left);
                }
                list.add(cur.val);
            }
            if (!list.isEmpty()) ans.add(new ArrayList<>(list));
            list.clear();
        }
        return ans;
    }
}
