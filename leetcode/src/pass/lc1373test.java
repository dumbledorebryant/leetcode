package pass;
import pass.TreeNode;
public class lc1373test {
    int sumTree=0;
    public static final int ISBST=0;
    public static final int MAX=1;
    public static final int MIN=2;
    public static final int SUM=3;

    public int maxSumBST(TreeNode root) {
        recursion(root);
        return sumTree;
    }
    private int[] recursion(TreeNode root){ // return [isBST, max, min, sum]
        if(root==null){
            return new int[]{1,Integer.MIN_VALUE,Integer.MAX_VALUE,0};
        }
        int[] left=recursion(root.left);
        int[] right=recursion(root.right);
        int[] ans={0,0,0,0};

        if(left[ISBST]==1 && right[ISBST]==1 && left[MAX]< root.val && right[MIN]> root.val){
            ans[ISBST]=1;
            ans[MAX]=Math.max(root.val,right[MAX]);
            ans[MIN]=Math.min(root.val,left[MIN]);
            ans[SUM]=root.val+left[SUM]+right[SUM];
            sumTree=Math.max(sumTree,ans[SUM]);
        }
        return ans;
    }
}
