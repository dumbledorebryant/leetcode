package pass;
import pass.TreeNode;
import java.util.*;
public class lc113 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> path, int targetSum){
        if (root == null) return;
        int num = root.val;
        
        if (targetSum == num){
            path.add(num);
            ans.add(new ArrayList<>(path));
            return;
        }
        else if (targetSum < num) return;
        
        else {
            path.add(num);
            dfs(root.left, path, targetSum - num);
            dfs(root.right, path, targetSum - num);
            path.remove(path.size() - 1);
        }
    }
}
