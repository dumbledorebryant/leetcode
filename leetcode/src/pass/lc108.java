package pass;

import java.util.Arrays;

import pass.TreeNode;
public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) return null;
        if (length == 1) return new TreeNode(nums[0]);
        int start = 0;
        int end = length - 1;
        int mid = start + ((length - start) >> 1);
        int num = nums[mid];
        TreeNode head = new TreeNode(num);
        int[] left = Arrays.copyOfRange(nums, start, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);
        head.left = sortedArrayToBST(left);
        head.right = sortedArrayToBST(right);
        return head;
    }
}
