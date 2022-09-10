package pass;
import java.util.*;
public class lc797 {
    List<List<Integer>> ans = new ArrayList<>();
    int target;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        target = graph.length - 1;
        dfs(graph, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[][] graph, int i, List<Integer> path){
        if (i == target){
            path.add(i);
            ans.add(new ArrayList<>(path));
            return;
        }

        path.add(i);
        int[] nexts = graph[i];
        for (int next : nexts){
            dfs(graph, next, path);
        }
        path.remove(path.size() - 1);
    }
}
