package pass;

import java.util.ArrayList;
import java.util.List;

public class lc1382 {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int n = list.size();
        return build(list, 0, n - 1);
    }

    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public TreeNode build(List<Integer> list, int i, int j){
        if (i > j) return null;
        int mid = i + (j - i)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, i, mid - 1);
        root.right = build(list, mid + 1, j);
        return root;
    }
}
