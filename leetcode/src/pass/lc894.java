package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc894 {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int i, int j){
        int n = j - i + 1;
        if (map.containsKey(n)) return map.get(n);
        List<TreeNode> ans = new ArrayList<>();
        if (n <= 0) {
            ans.add(null);
            return ans;
        }
        TreeNode root = new TreeNode(0);
        if (n == 1) {
            ans.add(root);
            return ans;
        }
        
        
        for (int k = i; k <= j; k++){
            if ((k - i) % 2 == 0) continue;
            if ((j - k) % 2 == 0) continue;
            List<TreeNode> left = helper(i, k - 1);
            List<TreeNode> right = helper(k + 1, j);

            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode temp = new TreeNode(0);
                    temp.left = l;
                    temp.right = r;
                    ans.add(temp);
                }
            }
        }
        map.put(n, ans);
        return ans;
    }
}
