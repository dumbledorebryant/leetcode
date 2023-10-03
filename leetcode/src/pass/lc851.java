package pass;

import java.util.ArrayList;
import java.util.List;

public class lc851 {
    boolean[] visited;
    int min = Integer.MAX_VALUE;
    int idx = -1;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : richer){
            int from = pair[0];
            int to = pair[1];
            graph[to].add(from);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            visited = new boolean[n];
            dfs(graph, i, quiet);
            ans[i] = idx;
            min = Integer.MAX_VALUE;
            idx = -1;
        }
        return ans;
    }

    public void dfs(List<Integer>[] graph, int i, int[] quiet){
        if (visited[i]) return;
        List<Integer> adjs = graph[i];
        visited[i] = true;
        int val = quiet[i];
        if (val < min){
            min = val;
            idx = i;
        }
        for (int next : adjs){
            dfs(graph, next, quiet);
        }
        return;
    }
}
