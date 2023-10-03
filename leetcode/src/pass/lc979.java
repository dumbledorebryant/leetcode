package pass;

public class lc979 {
    int sum = 0;
    public int distributeCoins(TreeNode root) {
        getCoins(root);
        return sum;
    }
    
    private int getCoins(TreeNode node){
        if (node == null)
            return 0;
        int left = getCoins(node.left);
        int right = getCoins(node.right);
        int total = left + right + node.val - 1;
        sum += Math.abs(total);
        return total;
    }
}
