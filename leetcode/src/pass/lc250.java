package pass;

public class lc250 {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        getNum(root);
        return count;
    }
    public int getNum(TreeNode root){
        if (root == null) return 1001;
        int num = root.val;
        if (root.left == null && root.right == null) {
            count++;
            return num;
        }
        
        int left = getNum(root.left);
        int right = getNum(root.right);
        if (left == 1001 && num == right) {
            count++;
            return num;
        }
        else if (right == 1001 && num == left) {
            count++; 
            return num;
        }
        else if (num == right && num == left) {
            count++;
            return num;
        }
        return 1002;
    }
}
