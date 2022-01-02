package pass;
import pass.TreeNode;
import java.util.*;
public class lc95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    public List<TreeNode> build(int low, int high){
        List<TreeNode> res = new ArrayList<>();

        if (low > high) {
            res.add(null);
            return res;
        }
       
        for (int i = low; i <= high; i++){
            List<TreeNode> left_ts = build(low, i - 1);
            List<TreeNode> right_ts = build(i + 1, high);
            for (TreeNode left : left_ts){
                for (TreeNode right : right_ts){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
