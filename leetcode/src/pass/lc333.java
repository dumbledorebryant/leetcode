package pass;
public class lc333 {
    public int largestBSTSubtree(TreeNode root) {
        int[] res = largest(root);
        return res[2];
    }

    private int[] largest(TreeNode root){
        if (root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = largest(root.left);
        int[] right = largest(root.right);
        int num = root.val;
        if (num > left[1] && num < right[0]){
            int min = Math.min(num, left[0]);
            int max = Math.max(num, right[1]);
            int size = left[2] + 1 + right[2];
            return new int[]{min, max, size};
        }
        else {
            int size = Math.max(left[2], right[2]);
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, size};
        }
    }
}
