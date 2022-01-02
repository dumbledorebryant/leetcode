package pass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lc210 {
    boolean flag = false;
    boolean[] visited;
    boolean[] onpath;
    List<Integer> postorder = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onpath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }
        if (flag) return new int[]{};

        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            res[i] = postorder.get(i);
        }
        return res;
    }
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    public void traverse(List<Integer>[] graph, int node){
        if (onpath[node]) flag = true;
        if (flag || visited[node]) {
            return;
        }

        visited[node] = true;
        onpath[node] = true;
        for (int i : graph[node]){
            traverse(graph, i);
        }
        postorder.add(node);
        onpath[node] = false;
    }
}
