package pass;

import java.util.HashSet;

public class lc653 {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        int val = root.val;
        if (set.contains(k - val)) return true;
        set.add(val);
        return findTarget(root.left, k)
            || findTarget(root.right, k);
    }
}
