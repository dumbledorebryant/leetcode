package pass;
import pass.TreeNode;
import java.util.*;
public class lc1373 {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * 后序遍历二叉树。
     * @param root 根节点
     * @return 返回一个大小为4的[int]res数组
     * res[0] 记录以root为根的二叉树是否是BST，若为1则说明是BST，若为0则说明不是；
     * res[1] 记录以root为根的二叉树所有节点中的最小值
     * res[2] 记录以root为根的二叉树所有节点中的最大值
     * res[3] 记录以root为根的二叉树所有节点值之和
     */
    int[] traverse(TreeNode root) {
        // base case
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // 递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        // 后序遍历
        int[] res = new int[4];
        // 判断以root为根的二叉树是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            // 以root为根的二叉树是BST
            res[0] = 1;
            // 计算以root为根的BST的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以root为根的BST的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以root为根的BST的所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            maxSum = Math.max(maxSum, res[3]);
        } else { // 以root为根的二叉树不是BST
            res[0] = 0;// 既然不是，其他的值也没必要计算了，因为用不到
        }

        return res;
    }
}
