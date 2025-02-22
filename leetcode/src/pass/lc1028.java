package pass;

public class lc1028 {
    int cur_lvl = 0;
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode dummy = new TreeNode(-1);
        helper(dummy, 0, traversal);
        return dummy.left;
    }

    public void helper(TreeNode parent, int lvl, String s){
        int length = s.length();
        while (idx < length && cur_lvl == lvl){
            int num = 0;
            while (idx < length && Character.isDigit(s.charAt(idx))){
                num = num * 10 + (s.charAt(idx) - '0');
                idx++;
            }

            TreeNode node = new TreeNode(num);
            if (parent.left == null) parent.left = node;
            else parent.right = node;

            cur_lvl = 0;
            while (idx < length && s.charAt(idx) == '-'){
                cur_lvl++;
                idx++;
            }

            helper(node, lvl + 1, s);
        }
    }
}
