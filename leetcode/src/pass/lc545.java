package pass;
import java.util.*;

public class lc545 {
    List<Integer> lb = new ArrayList<>();
    List<Integer> rb = new ArrayList<>();
    List<Integer> lf = new ArrayList<>();
    Set<TreeNode> set = new HashSet<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        set.add(root);
        if (root.left != null)
            leftdfs(root.left);
        leavesdfs(root);
        if (root.right != null);
            rightdfs(root.right);
        
        ans.addAll(lb);
        ans.addAll(lf);
        Collections.reverse(rb);
        ans.addAll(rb);
        return ans;
    }
    public void leftdfs(TreeNode root){
        if (root == null) return;
        if (!set.contains(root)){
            lb.add(root.val);
            set.add(root);
        }
        if (root.left != null)
            leftdfs(root.left);
        else 
            leftdfs(root.right);
    }
    public void rightdfs(TreeNode root){
        if (root == null) return;
        if (!set.contains(root)){
            rb.add(root.val);
            set.add(root);
        }
        if (root.right != null)
            rightdfs(root.right);
        else 
            rightdfs(root.left);
    }
    public void leavesdfs(TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (!set.contains(root)){
                lf.add(root.val);
                set.add(root);
            }
        }
        else {
            leavesdfs(root.left);
            leavesdfs(root.right);
        }
    }
}
