package pass;
import java.util.*;

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

class Solution{
    Map<Integer, TreeNode> map = new HashMap<>(); 
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root != null) getParent(root);
        dfs(target, k, null);
        return ans;
    }

    public void getParent(TreeNode root){
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l != null) {
            map.put(l.val, root);
            getParent(l);
        }
        if (r != null) {
            map.put(r.val, root);
            getParent(r);
        }
    }

    public void dfs(TreeNode root, int cur, TreeNode from){
        if (root == null) return;
        if (cur == 0){
            ans.add(root.val);
            return;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;
        int val = root.val;
        if (map.containsKey(val)){
            TreeNode p = map.get(val);
            if (p != from){
                dfs(p, cur - 1, root);
            }
        }
        
        if (l != from){
            dfs(l, cur - 1, root);
        }
        if (r != from){
            dfs(r, cur - 1, root);
        }
    }
}