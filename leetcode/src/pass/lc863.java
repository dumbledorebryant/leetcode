package pass;
import java.util.*;

import pass.OA.Cisco.queenAttack;
public class lc863 {
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        findParents(root);
        dfs(target, null, 0, k);
        return ans;
    }

    public void findParents(TreeNode root){
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            parents.put(left.val, root);
            findParents(left);
        }
        if (right != null){
            parents.put(right.val, root);
            findParents(right);
        }
    }

    public void dfs(TreeNode root, TreeNode from, int depth, int k){
        if (root == null) return;
        if (depth == k){
            ans.add(root.val); 
            return;
        }
        if (root.left != from){
            dfs(root.left, root, depth + 1, k);
        }
        if (root.right != from){
            dfs(root.right, root, depth + 1, k);
        }
        if (parents.get(root.val) != from){
            dfs(parents.get(root.val), root, depth + 1, k);
        }
    }
}
