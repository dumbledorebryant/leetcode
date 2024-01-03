package pass;

import java.util.ArrayList;
import java.util.List;

public class lc872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        int i = list1.size();
        int j = list2.size();
        if (i != j) return false;
        for (int m = 0; m < i; m++){
            if (list1.get(m) != list2.get(m)) return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        else {
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}
