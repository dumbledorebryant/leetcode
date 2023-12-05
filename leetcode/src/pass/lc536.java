public class lc536 {
    int i = 0;
    public TreeNode str2tree(String s) {
        TreeNode root = null;
        int n = s.length();
        if (n == 0) return root;
        int flag = 1;
        int sign = 1;
        int num = 0;
        while (i < n){
            char ch = s.charAt(i);
            i++;
            if (ch >= '0' && ch <= '9'){
                num = num * 10 + ch - '0';
                root = new TreeNode(sign * num);
            }
            else if (ch == '-'){
                sign = -1;
            }
            else if (ch == '(' && flag == 1){
                root.left = str2tree(s);
                flag = 2; 
            }
            else if (ch == '(' && flag == 2){
                root.right = str2tree(s); 
            }
            else if (ch == ')'){
                return root;
            }
        }
        return root;
    }
}
