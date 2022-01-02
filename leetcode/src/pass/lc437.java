package pass;

import pass.TreeNode;

public class lc437 {
    int count = 0;
    int sum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        sum = targetSum;
        dfs(root);
        return count;
    }
    public void dfs(TreeNode root){
        if (root == null) return;
        dfsroot(root, sum);
        dfs(root.left);
        dfs(root.right);
    }

    public void dfsroot(TreeNode start, int left){
        if (left == start.val) count++;
        left -= start.val;
        if (start.left != null) dfsroot(start.left, left);
        if (start.right != null) dfsroot(start.right, left);
    }
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println(pathSum(node1, 3));
        return;
    }
}