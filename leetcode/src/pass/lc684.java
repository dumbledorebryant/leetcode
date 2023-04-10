package pass;

import java.util.*;

public class lc684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges){
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            indegree[a]++;
            indegree[b]++;
            graph[a].add(b);
            graph[b].add(a);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indegree[i] == 1)
                queue.addLast(i);
        }

        while (!queue.isEmpty()){
            int cur = queue.removeFirst();
            for (int next : graph[cur]){
                indegree[next]--;
                if (indegree[next] == 1)
                    queue.addLast(next);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (indegree[i] > 1){
                set.add(i);
            }
        }

        for (int i = n - 1; i >= 0; i++){
            int[] edge = edges[i];
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            if (set.contains(a) || set.contains(b))
                return edge;
        }
        return new int[]{0, 0};
    }
}
