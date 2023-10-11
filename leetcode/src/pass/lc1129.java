package pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class lc1129 {
    int[] colors;
    int[] ans;
    int n;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        colors = new int[n];
        ans = new int[n];
        this.n = n;
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] r : redEdges){
            graph[r[0]].add(new int[]{r[1], 1});
        }

        for (int[] b : blueEdges){
            graph[b[0]].add(new int[]{b[1], 2});
        }

        bfs(graph);
        return ans;
    }

    public void bfs(List<int[]>[] graph){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});

        int step = 0;
        while (!dq.isEmpty()){
            
            int size = dq.size();
            for (int i = 0; i < size; i++){
                int[] cur = dq.removeFirst();
                int node = cur[0];
                int pre = cur[1];
                ans[node] = ans[node] == -1 ? step : ans[node];
                List<int[]> nexts = graph[node];
                for (int[] next : nexts){
                    int nn = next[0];
                    int nc = next[1];
                    if (nn == -1){
                        continue;
                    }
                    if (nc != pre){
                        dq.addLast(new int[]{nn, nc});
                        next[0] = -1;
                    }
                }
            }
            step++;
        }
    }
}
