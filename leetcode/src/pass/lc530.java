package pass;

import java.util.ArrayList;
import java.util.List;

public class lc530 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        preOrder(root);
        int n = list.size();
        int ans = 100000;
        for (int i = 1; i < n; i++){
            ans = Math.min(ans, (list.get(i) - list.get(i - 1)));
        }
        return ans;
    }

    public void preOrder(TreeNode root){
        if (root == null) return;
        preOrder(root.left);
        list.add(root.val);
        preOrder(root.right);
    }
}
