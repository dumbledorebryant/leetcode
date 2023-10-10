package pass;

import java.util.ArrayList;
import java.util.List;

public class lc1466 {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];    
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : connections){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(-from);
        }
        
        dfs(graph, 0, new boolean[n]);
        
        return ans;
    }

    public void dfs(List<Integer>[] graph, int i, boolean[] visited){
        visited[i] = true;
        List<Integer> nexts = graph[i];
        for (int next : nexts){
            if (!visited[Math.abs(next)]){
                if (next > 0){
                    ans++;
                }
                
                dfs(graph, Math.abs(next), visited);
            }
        }
    }
}
