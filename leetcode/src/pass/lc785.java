package pass;

import java.util.*;
public class lc785 {
    boolean ans = true;
    boolean[] visited;
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++){
            if (!visited[i])
                bfs(graph, i);
        }
        return ans;
    }

    public void bfs(int[][] grid, int start){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        color[start] = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int node = queue.removeFirst();
                int[] neightbors = grid[node];
                for (int next : neightbors){
                    if (visited[next]){
                        if (color[next] == color[node]){
                            ans = false;
                            return;
                        }
                    }
                    else {
                        visited[next] = true;
                        color[next] = 1 - color[node];
                        queue.addLast(next);
                    }
                }
            }
        }
    }
}
