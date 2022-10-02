package pass.OA.Doordash;

import java.util.*;

public class MiniRoute {
    private static int[] dijkstra(int source, int n, Map<Integer, List<int[]>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
        dist[source] = 0;
        pq.offer(source);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (graph.containsKey(curr)) {
                for (int[] next : graph.get(curr)) {
                    int nextNode = next[0], nextWeight = next[1];
                    if (dist[nextNode] > dist[curr] + nextWeight) {
                        dist[nextNode] = dist[curr] + nextWeight;
                        pq.offer(nextNode);
                    }
                }
            }
        }
        return dist;
    }

    public static int getShortestPath(int n, int a, int b, int c, int[] roadsFrom, int[] roadsTo, int[] roadsWeight) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < roadsFrom.length; ++i) {
            graph.computeIfAbsent(roadsFrom[i], k -> new ArrayList<>()).add(new int[]{roadsTo[i], roadsWeight[i]});
            graph.computeIfAbsent(roadsTo[i], k -> new ArrayList<>()).add(new int[]{roadsFrom[i], roadsWeight[i]});
        }

        int[] distA = dijkstra(a, n, graph);
        int[] distB = dijkstra(b, n, graph);
        int[] distC = dijkstra(c, n, graph);

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < distA.length; ++i) {
            if (distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE && distC[i] != Integer.MAX_VALUE) {
                minDist = Math.min(minDist, distA[i] + distB[i] + distC[i]);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static void main(String[] args) {
        System.out.println(getShortestPath(4, 1, 3, 2, new int[]{0, 0, 0}, new int[]{2, 1, 3}, new int[]{1, 2, 3}));
    }
}
