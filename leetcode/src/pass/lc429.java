package pass;
import java.util.*;
public class lc429 {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.removeFirst();
                layer.add(node.val);
                for (Node child : node.children){
                    if (child != null){
                        queue.addLast(child);
                    }
                }
            }
            ans.add(layer);
        }
        return ans;
    }
}
