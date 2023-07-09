package pass;

public class lc270 {
    double diff = Double.MAX_VALUE;
    int ans = -1;
    int pre = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        int num = root.val;
        if (target == num){
            ans = num;
        }
        else if (target < num){
            double ndiff = Math.abs(num - target);
            if (ndiff <= diff){
                if (ndiff == diff){
                    if (num < pre){
                        ans = num;
                        diff = ndiff;
                        pre = num;
                    }
                }
                else{
                    ans = num;
                    diff = ndiff;
                    pre = num;
                }
            }
            closestValue(root.left, target);
        }
        else {
            double ndiff = Math.abs(num - target);
            if (ndiff <= diff){
                if (ndiff == diff){
                    if (num < pre){
                        ans = num;
                        diff = ndiff;
                        pre = num;
                    }
                }
                else{
                    ans = num;
                    diff = ndiff;
                    pre = num;
                }
            }
            closestValue(root.right, target);
        }
        return ans;
    }
}
