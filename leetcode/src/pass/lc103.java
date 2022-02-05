package pass;

import java.util.*;
public class lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty() || !queue.isEmpty()){
            while (!q.isEmpty()){
                TreeNode cur = q.poll();
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
                    q.add(right);
                }
                if (left != null){
                    q.add(left);
                }
                list.add(cur.val);
            }
            if (!list.isEmpty()) ans.add(new ArrayList<>(list));
            list.clear();
        }
        return ans;
    }
}
