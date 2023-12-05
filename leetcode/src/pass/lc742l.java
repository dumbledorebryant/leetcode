package pass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class lc742l {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        buildGraph(graph, queue, root, null, k);
        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null && node.left == node.right)
                return node.val;
            visited.add(node);
            List<TreeNode> nodes = graph.get(node);
            for (TreeNode tn : nodes){
                if (!visited.contains(tn)){
                    queue.offer(tn);
                }
            }
        }
        return 0;
    }
    
    private void buildGraph(Map<TreeNode, List<TreeNode>> graph, Queue<TreeNode> queue, TreeNode node, TreeNode parent, int k){
        if (node == null)
            return;
        if (node.val == k){
            queue.offer(node);
        }
        graph.putIfAbsent(node, new LinkedList<>());
        graph.putIfAbsent(parent, new LinkedList<>());
        graph.get(node).add(parent);
        graph.get(parent).add(node);
        buildGraph(graph, queue, node.left, node, k);
        buildGraph(graph, queue, node.right, node, k);
    }
}
