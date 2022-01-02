package pass;

import org.junit.Test;
public class lc98Test {
    @Test
    public void testIsValidBST() {
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        TreeNode left = null;
        TreeNode right = new TreeNode(Integer.MIN_VALUE);
        node.left = left;
        node.right = right;
        lc98 test = new lc98();
        System.out.println(test.isValidBST(node));
    }
}
