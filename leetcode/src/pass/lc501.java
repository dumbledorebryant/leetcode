package pass;
import java.util.*;
public class lc501 {
    int max = 1;
    int count = -1;
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        int num = root.val;
        findMode(root.left);
        if (pre == null){
            count = 1;
            if (max == count){
                list.add(num);
            }
        }
        else if (pre.val == num){
            count++;
            if (max == count){
                list.add(num);
            }
            if (max < count){
                list.clear();
                list.add(num);
                max = count;
            }
        }
        else {
            count = 1;
            if (max == count){
                list.add(num);
            }
        }
        pre = root;
        findMode(root.right);
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
