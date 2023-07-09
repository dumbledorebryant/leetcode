package pass;

import java.util.ArrayList;
import java.util.List;

public class lc366 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        while (root.left != null || root.right != null){
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            ans.add(list);
        }
        List<Integer> r = new ArrayList<>();
        r.add(root.val);
        ans.add(r);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (test(left)){
            list.add(left.val);
            root.left = null;
        } else {
            dfs(left, list);
        }
        if (test(right)){
            list.add(right.val);
            root.right = null;
        } else {
            dfs(right, list);
        }
    }

    public boolean test(TreeNode root){
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return false;
    }
}
