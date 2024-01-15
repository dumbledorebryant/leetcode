package pass;

import java.util.HashSet;
import java.util.Set;

public class lc1676 {
    Set<TreeNode> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes){
            set.add(node);
        }
        return find(root, set);
    }

    public TreeNode find(TreeNode root, Set<TreeNode> set){
        if (root == null) return null;
        if (set.contains(root)){
            return root;
        }

        TreeNode left = find(root.left, set);
        TreeNode right = find(root.right, set);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
