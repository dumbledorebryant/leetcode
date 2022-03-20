package pass;
import java.util.*;

import pass.TreeNode;
public class lc297 {
    // Encodes a tree to a single string.
    public String preorder_serialize(TreeNode root) {
        if (root == null) return "#";
        String res = "";
        res += Integer.toString(root.val);
        res += ","; // not "#"
        res += preorder_serialize(root.left);
        res += ",";
        res += preorder_serialize(root.right);
        return res;
    }
    public String postorder_serialize(TreeNode root) {
        if (root == null) return "#";
        String res = "";
        res += postorder_serialize(root.left);
        res += ",";
        res += postorder_serialize(root.right);
        res += ",";
        res += Integer.toString(root.val);
        return res;
    }
    // Encodes a tree to a single string.
    public String layers_serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#").append(",");
                continue;
            }
            queue.add(root.left);
            queue.add(root.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>();
        String[] strl = data.split(",");
        for (String str : strl){
            list.add(str);
        }
        return postorder_destr(list);
    }

    public TreeNode preorder_destr(List<String> list){
        if (list.isEmpty()) return null;
        String strr = list.get(0);
        list.remove(0);
        if (strr.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strr));
        root.left = preorder_destr(list);
        root.right = preorder_destr(list);
        return root;
    }
    public TreeNode postorder_destr(List<String> list){
        if (list.isEmpty()) return null;
        int index = list.size() - 1;
        String strr = list.get(index);
        list.remove(index);
        if (strr.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strr));
        root.left = postorder_destr(list);
        root.right = postorder_destr(list);
        return root;
    }

    public TreeNode layers_destr(String data){
        return null;
    }
}
