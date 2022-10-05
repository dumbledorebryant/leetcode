package pass.Company.Palantir.Karat;

import java.util.*;

public class EarliestAncestor {
    public int findEarliestAncestor(int[][] edges, int x){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            map.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited.add(x);
        int ans = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int node = queue.poll();
                ans = node;
                if (map.containsKey(node)){
                    for (int p : map.get(node)){
                        if (!visited.contains(p)){
                            queue.add(p);
                            visited.add(p);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
