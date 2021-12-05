package pass;

import java.beans.Transient;
import java.util.*;

public class lc98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        else {
            List<Integer> lp = isBST(root.left);
            List<Integer> rp = isBST(root.right);
            int num = root.val;
            if (rp != null && num >= rp.get(0)) return false;
            if (lp != null && num <= lp.get(1)) return false;
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
    public List<Integer> isBST(TreeNode root) {
        if (root == null) return null;
        int min, max;
        List<Integer> pair = new ArrayList<>();
        List<Integer> lp = isBST(root.left);
        List<Integer> rp = isBST(root.right);
        int num = root.val;
        if (lp != null) min = lp.get(0);
        else min = num;
        if (rp != null) max = rp.get(1);
        else max = num;
        pair.add(min);
        pair.add(max);
        return pair;
    }
}
