package pass;

import java.math.MathContext;

public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if (right < left) return null;
        if (right == left) return new TreeNode(nums[left]);
        
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++){
            int num = nums[i];
            if (num > max){
                max = num;
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = helper(nums, left, index - 1);
        root.right = helper(nums, index + 1, right);
        return root;
    }
}
