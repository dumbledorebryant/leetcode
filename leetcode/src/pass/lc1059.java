package pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1059 {
    enum Color {
        WHITE, GRAY, BLACK
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int[] edge : edges) {
            if (adjList[edge[0]] == null) adjList[edge[0]] = new ArrayList<>();
            adjList[edge[0]].add(edge[1]);
        }
        Color[] visited = new Color[n];
        Arrays.fill(visited, Color.WHITE);
        return dfs(source, destination, adjList, visited);
    }

    private boolean dfs(int source, int dest, List<Integer>[] adjList, Color[] visited) {
        if (adjList[source] == null) return source == dest;

        if (visited[source] == Color.BLACK) return true;
        if (visited[source] == Color.GRAY) return false;
        visited[source] = Color.GRAY;
        for (int neighbour : adjList[source])
            if (!dfs(neighbour, dest, adjList, visited)) return false;
        visited[source] = Color.BLACK;
        return true;
    }
}
