package pass;
import java.util.*;

public class lc841 {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            List<Integer> list = rooms.get(i);
            graph[i] = new ArrayList<>();
            int size = list.size();
            for (int j = 0; j < size; j++){
                int next = list.get(j);
                graph[i].add(next);
            }
        }
        dfs(graph, 0);
        for (int i = 0; i < n; i++){
            if (!visited[i]) return false;
        }
        return true;
    }
    public void dfs(List<Integer>[] graph, int cur){
        if (visited[cur]) return;
        visited[cur] = true;
        for (int next : graph[cur]){
            dfs(graph, next);
        }
        return;
    }
}
