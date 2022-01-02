package pass;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import pass.TreeNode;
public class lc652 {
    List<TreeNode> ans;
    Map<String, Integer> subtrees;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        subtrees = new HashMap<>();
        findSubtree(root);
        return ans;
    }
    public String findSubtree(TreeNode root){
        if (root == null) return "#";
        String sub = String.valueOf(root.val);
        sub += ",";
        sub += findSubtree(root.left);
        sub += ",";
        sub += findSubtree(root.right);
        if (!subtrees.containsKey(sub)) subtrees.put(sub, 0);
        else {
            if (subtrees.get(sub) == 0) {
                ans.add(root);
                subtrees.put(sub, 1);
            }
        }
        return sub;
    }
}
