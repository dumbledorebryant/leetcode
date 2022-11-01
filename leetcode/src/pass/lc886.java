package pass;
import java.util.*;

public class lc886 {
    boolean ans = true;
    boolean[] visited;
    boolean[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n];
        color = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes){
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                bfs(graph, i);
            }
        }
        return ans;
    }

    public void bfs(List<Integer>[] graph, int start){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        color[start] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int node = queue.removeFirst();
                List<Integer> neighbors = graph[node];
                for (int next : neighbors){
                    if (visited[next]){
                        if (color[next] == color[node]){
                            ans = false;
                            return;
                        }
                    }
                    else {
                        visited[next] = true;
                        color[next] = !color[node];
                        queue.addLast(next);
                    }
                }
            }
        }
    }
}
