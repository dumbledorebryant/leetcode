package pass;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class lc133 {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        if (map.containsKey(node)) return map.get(node);
        Node ans = new Node(node.val);
        map.put(node, ans);
        for (Node n : node.neighbors){
            ans.neighbors.add(cloneGraph(n));
        }
        return ans;
    }
}
