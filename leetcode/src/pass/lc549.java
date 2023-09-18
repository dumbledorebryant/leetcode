package pass;

public class lc549 {
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        path(root);
        return ans;
    }

    public int[] path(TreeNode root){
        int[] res = new int[2];
        if (root == null) return new int[0];
        int v = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;

        int[] l = path(root.left);
        int[] r = path(root.right);
        
        int li = (l.length > 0 && v - left.val == 1) ? l[0] : 0;
        int ld = (l.length > 0 && v - left.val == -1) ? l[1] : 0;
        int ri = (r.length > 0 && v - right.val == 1) ? r[0] : 0;
        int rd = (r.length > 0 && v - right.val == -1) ? r[1] : 0;

        ans = Math.max(ans, 1 + Math.max(li + rd, ld + ri));
        res[0] = Math.max(li, ri) + 1;
        res[1] = Math.max(ld, rd) + 1;
        return res;
    }
}
