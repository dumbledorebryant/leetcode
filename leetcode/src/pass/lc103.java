package pass;

import java.util.*;
public class lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        queue.add(root);
        boolean ltor = true;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();

                int num = cur.val;
                if (ltor) {
                    level.add(num);
                }
                else level.add(0, num);
                
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null){
                    queue.add(left);
                }
                if (right != null){
                    queue.add(right);
                }
            }
            ans.add(level);
            ltor = !ltor;
        }
        return ans;
    }
    public List<List<Integer>> zigzagLevelTraverse(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int flag = 1;
        
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            if (flag == 1){
                for (int i = 0; i < size; i++){
                    TreeNode node = deque.removeFirst();
                    temp.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (left != null) deque.addLast(left);
                    if (right != null) deque.addLast(right);
                }
            }
                
            else {
                for (int i = 0; i < size; i++){
                    TreeNode node = deque.removeLast();
                    temp.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (right != null) deque.addFirst(right);
                    if (left != null) deque.addFirst(left);
                }
            }
            ans.add(temp);
            flag = 1 - flag;
        }
        return ans;
    }
}
