package pass;

public class lc1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return bst(preorder, 0, n - 1);
    }

    public TreeNode bst(int[] nodes, int i, int j){
        if (i > j) return null;
        int rnum = nodes[i];
        TreeNode root = new TreeNode(rnum);
        int k = i + 1;
        for (; k <= j; k++){
            int num = nodes[k];
            if (num > rnum){
                break;
            }
        }
        root.left = bst(nodes, i + 1, k - 1);
        root.right = bst(nodes, k, j);
        return root;
    }
}
