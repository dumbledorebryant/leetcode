package pass;

import java.util.HashMap;
import java.util.Map;

public class lc993 {
    Map<Integer, TreeNode> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        int a = check(root, null, x, 0);
        int b = check(root, null, y, 0);
        if (a == b){
            if (map.get(x).val != map.get(y).val) return true;
        }
        return false;
    }

    public int check(TreeNode a, TreeNode p, int x, int depth){
        if (a == null) return -1;
        if (a.val == x) {
            map.put(x, p);
            return depth;
        } 
        int left = check(a.left, a, x, depth + 1);
        int right = check(a.right, a, x, depth + 1);
        if (left != -1) return left;
        return right;
    }
}
