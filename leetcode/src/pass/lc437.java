package pass;

import java.util.*;

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
    int ans = 0;
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        psum(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    public void psum(TreeNode root, long pre, int t){
        if (root == null) return;
        long num = root.val;
        long cur = pre + num;
        if (cur == t) ans++;
        psum(root.left, cur, t);
        psum(root.right, cur, t);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
}