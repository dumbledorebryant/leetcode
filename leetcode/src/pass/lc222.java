package pass;
import java.util.*;

import pass.TreeNode;
public class lc222 {
    public int countNodes(TreeNode root) {
        TreeNode l = root; 
        TreeNode r = root;
        int hl = 0;
        int hr = 0;
        while (l != null){
            hl++;
            l = l.left;
        }
        while (r != null){
            hr++;
            r = r.right;
        }
        if (hr == hl) return (int)Math.pow(2, hl) - 1;
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
