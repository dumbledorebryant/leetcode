package pass;

public class lc1120 {
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
       
        return max;
    }

    public int[] dfs(TreeNode root){
        int[] ans = new int[2];

        if (root == null) return ans;

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        ans[0] = left[0] + right[0] + root.val;
        ans[1] = left[1] + right[1] + 1;
        
        double temp = ans[0] * 1.0 / ans[1];
        if (temp > max) max = temp;
        return ans;
    }
}
