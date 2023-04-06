package pass;
import java.util.*;
public class lc257 {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root.left == null && root.right == null){
            ans.add(String.valueOf(root.val));
            return ans;
        }
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb){
        if (root == null) return;
        int num = root.val;
        String temp = String.valueOf(num);
        if (root.left == null && root.right == null){
            sb.append(num);
            ans.add(sb.toString());
            int size = sb.length();
            sb.delete(size - temp.length(), size);
            return;
        }
        sb.append(num).append("->");
        dfs(root.left, sb);
        dfs(root.right, sb);
        int size = sb.length();
        sb.delete(size - temp.length() - 2, size);
    }
}
