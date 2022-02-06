package pass;

public class lc124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] ans = maxsum(root);
        return max;
    }

    public int[] maxsum(TreeNode root){
        int[] left = new int[]{0, 0};
        int[] right = new int[]{0, 0};

        if (root.left != null)
            left = maxsum(root.left);
        if (root.right != null)
            right = maxsum(root.right);

        int num = root.val;
        int[] ans = new int[2];
        ans[0] = left[1] + num + right[1];
        ans[1] = Math.max(Math.max(left[1], right[1]), 0) + num;
        max = Math.max(max, ans[0]);
        max = Math.max(max, ans[1]);
        return ans;
    }
}
