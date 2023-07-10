package pass;
import java.util.*;
public class lc449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] list = data.split(",");
        List<String> slist = new ArrayList<>();
        for (String str : list) slist.add(str);
        return des(slist);
    }

    public TreeNode des(List<String> list){
        if (list.size() == 0) return null;
        String str = list.get(0);
        list.remove(0);
        if (str.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = des(list);
        root.right = des(list);
        return root;
    }
}
