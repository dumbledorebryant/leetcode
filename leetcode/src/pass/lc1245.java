package pass;

import java.util.*;

public class lc1245 {
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] degrees = new int[n];
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            degrees[a]++;
            degrees[b]++;
            graph[a].add(b);
            graph[b].add(a);
        }
        int ans = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (degrees[i] == 1)
                queue.addLast(i);
        }

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (n == 1) return 2 * level;
            if (n == 2) return 2 * level + 1;
            for (int i = 0; i < size; i++){
                int cur = queue.removeFirst();
                n--;
                for (int next : graph[cur]){
                    degrees[next]--;
                    if (degrees[next] == 1)
                        queue.addLast(next);
                }
            }
            level++;
        }
        
        return 0;
    }
}
